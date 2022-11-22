package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.OrderDAO;
import com.gordeeva.courses.ShoesStore.dao.ProductDAO;
import com.gordeeva.courses.ShoesStore.dao.ShoppingCartItemDAO;
import com.gordeeva.courses.ShoesStore.models.OrderEntity;
import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import com.gordeeva.courses.ShoesStore.models.ShoppingCartItemEntity;
import com.gordeeva.courses.ShoesStore.models.dto.AddProductToCartDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final ProductDAO productDAO;
    private final ShoppingCartItemDAO shoppingCartItemDAO;

    private final ProductService productService;

    private final OrderDAO orderDAO;

    /*
    * В этом методе который хэндлит этот запрос будем рассчитывать
    * сумму за все единицы определенного товара в корзине, и конвертировать
    *  данные полученные из дтошки в энтити
    * и сохранять в базу в таблицу ShoppingCartItem, обновить кол-во товара из корзины*/

    public void convertAddToCartDTOtoShoppingCartItem(AddProductToCartDTO addProductToCartDTO){
        //calculate amount price of item in shopping cart
        float amount = calculateAmountPriceOfItemInCart(addProductToCartDTO.getCartItemQty(),
                addProductToCartDTO.getProductId());

        ShoppingCartItemEntity shoppingCartItem = new ShoppingCartItemEntity();
        shoppingCartItem.setProductId(addProductToCartDTO.getProductId());
        shoppingCartItem.setQtyOfItemInCart(addProductToCartDTO.getCartItemQty());
        shoppingCartItem.setAmountOfItemInCart(amount);
        shoppingCartItem.setOrderId(addProductToCartDTO.getOrderId());

        //create such order before saving to the shopping cart
        saveOrderId(addProductToCartDTO.getOrderId());

        //save to the shopping_cart_item table this shoppingCartItem
        saveProductAddedToCartToDb(shoppingCartItem);

        //Update the product qty in product table
        productService.updateQtyAfterCustomerAddedProductToCart(addProductToCartDTO.getProductId(),
         addProductToCartDTO.getCartItemQty());


    }

    // TODO: 11/18/22 Пофиксить order_id добавление в shopping_cart_item
    // TODO: проблема в том что когда добавляем товар еще один в уже
    // TODO: существующий заказ, оrder_id у предыдущего становится null
    public void saveOrderId(Long id){
        //надо проверять если не существует уже заказа с таким id ???
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(id);
        orderDAO.save(orderEntity);
    }

    public void saveProductAddedToCartToDb(ShoppingCartItemEntity shoppingCartItemEntity){
        shoppingCartItemDAO.save(shoppingCartItemEntity);
    }


    public float calculateAmountPriceOfItemInCart(int cartItemQty, Long productId){

        float productPrice = getProductPrice(productId);

        float amountPriceOfItemInCart = productPrice * cartItemQty;

        return amountPriceOfItemInCart;

    }

    public float getProductPrice(Long productId){
        //find out element with such id and get it price
        Optional<ProductEntity> optionalProductEntity = productDAO.findById(productId);
        float productPrice = optionalProductEntity.isPresent() ?
                optionalProductEntity.get().getPrice() :  -1.0f;

        return productPrice;
    }

    public List<ShoppingCartItemEntity> getShoppingCartItems(){
        List<ShoppingCartItemEntity> shoppingCartItems = shoppingCartItemDAO.findAll();
        return shoppingCartItems;
    }
}

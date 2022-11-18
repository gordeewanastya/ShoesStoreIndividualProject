package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.OrderDAO;
import com.gordeeva.courses.ShoesStore.dao.ProductDAO;
import com.gordeeva.courses.ShoesStore.models.OrderEntity;
import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import com.gordeeva.courses.ShoesStore.models.ShoppingCartItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;

//    //change to better return statement
//    public OrderEntity getOrderDetail(Long orderId) {
//        Optional<OrderEntity> order = this.orderDAO.findById(orderId);
//        return order.isPresent() ? order.get() : null;
//    }
//
//    public float getCartAmount(List<ShoppingCartItemEntity> shoppingCartItemsList){
//        float totalCartAmount = 0f;
//        float singleCartAmount = 0f;
//        int availableQuantity = 0;
//
//        for (ShoppingCartItemEntity item: shoppingCartItemsList){
//            Long productID = item.getProductId();
//            Optional<ProductEntity> optional = productDAO.findById(productID);
//            if (optional.isPresent()){
//                ProductEntity product = optional.get();
//                if (product.getQty() < item.getQtyOfItemInCart()){
//                    //if customer wants to get more than we really have qty
//                     singleCartAmount = product.getPrice() * product.getQty();
//                     item.setAmountOfItemInCart(product.getQty());
//                } else{
//                    singleCartAmount = item.getQtyOfItemInCart() * product.getPrice();
//                    availableQuantity = product.getQty() - item.getQtyOfItemInCart();
//                }
//                totalCartAmount = totalCartAmount + singleCartAmount;
//                product.setQty(availableQuantity);
//                availableQuantity = 0;
//                item.setProductName(product.getName());
//                item.setAmountOfItemInCart(singleCartAmount);
//                productDAO.save(product); // скорее всего update продукт
//            }
//        }
//        return totalCartAmount;
//    }
//
//    public OrderEntity saveOrder(OrderEntity order){
//        return orderDAO.save(order);
//    }

}

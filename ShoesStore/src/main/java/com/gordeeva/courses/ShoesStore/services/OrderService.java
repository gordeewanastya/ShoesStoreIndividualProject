package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.Utils.DateUtil;
import com.gordeeva.courses.ShoesStore.dao.OrderDAO;
import com.gordeeva.courses.ShoesStore.dao.ProductDAO;
import com.gordeeva.courses.ShoesStore.models.CustomerEntity;
import com.gordeeva.courses.ShoesStore.models.OrderEntity;
import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import com.gordeeva.courses.ShoesStore.models.ShoppingCartItemEntity;
import com.gordeeva.courses.ShoesStore.models.dto.OrderDTO;
import lombok.AllArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;
    private final CustomerService customerService;

    public List<OrderEntity> getAllOrders(){
        List<OrderEntity> ordersList = orderDAO.findAll();
        return ordersList;
    }


    public String placeOrder(OrderDTO orderDTO){

        CustomerEntity customer = customerService.findById(orderDTO.getCustomerId());

        OrderEntity orderEntity = findOrderById(orderDTO.getOrderId());

        List<ShoppingCartItemEntity> itemsInCart = orderEntity.getCartItems();
        float totalPrice = calculateTotalPriceOfOrder(itemsInCart);


        orderEntity.setCustomer(customer);
        orderEntity.setTotal(totalPrice);
        orderEntity.setOrderCreationDate(DateUtil.getCurrentDateTime());

        orderDAO.save(orderEntity);


        return "Successfully placed an order!";


        //calculate the total price of all products in the shopping cart of this order -- ?
        //if successfully saved order to db then return string that succesfully added
        //otherwise THROW NEW RUNTIME_EXCEPTION("Couldn't save the order")
    }


    public float calculateTotalPriceOfOrder(List<ShoppingCartItemEntity> itemsInCart){
        float totalPrice = 0.0f;
        for (ShoppingCartItemEntity item: itemsInCart){
            totalPrice = totalPrice + item.getAmountOfItemInCart();
        }
        return totalPrice;
    }

    public OrderEntity findOrderById(Long id){
        Optional<OrderEntity> orderOptional = orderDAO.findById(id);
        if (orderOptional.isPresent()){
            return orderOptional.get();
        } else {
            throw new RuntimeException("Couldn't find the order with provided id:: " + id);
        }
    }


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

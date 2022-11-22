package com.gordeeva.courses.ShoesStore.controllers;


import com.gordeeva.courses.ShoesStore.Utils.DateUtil;
import com.gordeeva.courses.ShoesStore.models.CustomerEntity;
import com.gordeeva.courses.ShoesStore.models.OrderEntity;
import com.gordeeva.courses.ShoesStore.models.dto.OrderDTO;
import com.gordeeva.courses.ShoesStore.models.dto.ResponseOrderDTO;
import com.gordeeva.courses.ShoesStore.services.CustomerService;
import com.gordeeva.courses.ShoesStore.services.OrderService;
import com.gordeeva.courses.ShoesStore.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("user/order/")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity<Object> getAllOrders(){
        try {
            return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Object> placeOrder(@RequestBody OrderDTO orderDTO){
        try {
            return new ResponseEntity<>(orderService.placeOrder(orderDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Object> getOrderById(@PathVariable Long id){
//        try {
//            return new ResponseEntity<>(orderService.getOrderDetail(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PostMapping("/placeOrder")
//    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
//        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
//        float amount = orderService.getCartAmount(orderDTO.getCartItems());
//
//        CustomerEntity customer  = new CustomerEntity(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
//        Long customerIdFromDb = customerService.isCustomerPresent(customer);
//        if(customerIdFromDb != null){
//            customer.setId(customerIdFromDb);
//        } else{
//            customer = customerService.saveCustomer(customer);
//        }
//
//        OrderEntity order = new OrderEntity(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
//        order = orderService.saveOrder(order);
//
//        responseOrderDTO.setAmount(amount);
//        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
//        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
//        responseOrderDTO.setOrderId(order.getId());
//        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());
//
//        return ResponseEntity.ok(responseOrderDTO);
//    }

}

package com.gordeeva.courses.ShoesStore.models.dto;

import com.gordeeva.courses.ShoesStore.models.ShoppingCartItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long orderId;
    private Long customerId;
//    private String customerEmail;
//    private String customerName;

}

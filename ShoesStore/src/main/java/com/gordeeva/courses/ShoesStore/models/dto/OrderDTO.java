package com.gordeeva.courses.ShoesStore.models.dto;

import com.gordeeva.courses.ShoesStore.models.ShoppingCartItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private String orderDescription;
    private List<ShoppingCartItemEntity> cartItems;
    private String customerEmail;
    private String customerName;

}

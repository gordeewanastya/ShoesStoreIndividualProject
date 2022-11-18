package com.gordeeva.courses.ShoesStore.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductToCartDTO {
    //will store here what we get as request body to url "/addToCart"
    private Long productId;
    private int cartItemQty;
    private Long orderId;
}

package com.gordeeva.courses.ShoesStore.controllers;


import com.gordeeva.courses.ShoesStore.models.dto.AddProductToCartDTO;
import com.gordeeva.courses.ShoesStore.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProductToCart(@RequestBody AddProductToCartDTO addProductToCartDTO){
        try {
            shoppingCartService.convertAddToCartDTOtoShoppingCartItem(addProductToCartDTO);
            return new ResponseEntity<>("Successfully added product with id:: "
                    + addProductToCartDTO.getProductId() +
                    " to the ShoppingCart", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}

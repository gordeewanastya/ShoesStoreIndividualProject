package com.gordeeva.courses.ShoesStore.models.dto;


import com.gordeeva.courses.ShoesStore.models.CategoryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private float price;

    private int qty;

    private CategoryEntity size_category;


    private String createdAt;
    private String modifiedAt;
    private String deletedAt;
}

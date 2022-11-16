package com.gordeeva.courses.ShoesStore.models.dto;


import com.gordeeva.courses.ShoesStore.models.CategoryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private float price;

    private int qty;

    private CategoryEntity size_category;


    ///i could change it to date so we would see only date (without time)
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;
}



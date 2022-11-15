package com.gordeeva.courses.ShoesStore.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private float size_cm;
    private float size_eu;
    private float size_us;
}

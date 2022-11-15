package com.gordeeva.courses.ShoesStore.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private float size_cm;
    private float size_eu;
    private float size_us;

}

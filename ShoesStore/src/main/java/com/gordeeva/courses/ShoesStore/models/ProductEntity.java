package com.gordeeva.courses.ShoesStore.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_name")
    private String name;
    @Column(name = "prod_price")
    private float price;
    @Column(name = "prod_qty")
    private int qty;


    @ManyToOne // many products can have the same size category
    @JoinColumn(name= "prod_size_category") // contains name of the foreign key column
    private CategoryEntity size_category; //hibernate will see in the background that prod_size_category
    // references the table Category

    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "modified_at")
    private Timestamp modifiedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

}

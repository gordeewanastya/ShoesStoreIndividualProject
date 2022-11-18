package com.gordeeva.courses.ShoesStore.models;

import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shopping_cart_item")
public class ShoppingCartItemEntity {

    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;


    @Column(name = "cart_item_qty")
    private int QtyOfItemInCart;

    @Column(name = "cart_item_amount")
    private float AmountOfItemInCart;

    @Column(name = "order_id")
    private Long orderId;
}

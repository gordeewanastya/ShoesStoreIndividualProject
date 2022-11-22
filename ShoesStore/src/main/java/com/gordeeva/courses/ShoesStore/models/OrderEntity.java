package com.gordeeva.courses.ShoesStore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "order_info")
@NoArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "customer_id", referencedColumnName = "cust_id")

    //uni-directional Many orders to One customer
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private CustomerEntity customer;


//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingCartItemEntity.class)
//    @JoinColumn(name = "order_id", referencedColumnName = "order_id")

    //uni-directional One order to Many shopping cart items
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<ShoppingCartItemEntity> cartItems;

    @Column(name = "order_total")
    private double total;

    @Column(name = "order_creation_date")
    private String orderCreationDate;

    public OrderEntity(String orderDescription, CustomerEntity customer,
                       List<ShoppingCartItemEntity> cartItems, double total,
                       String orderCreationDate){

        this.customer = customer;
        this.cartItems = cartItems;
        this.total = total;
        this.orderCreationDate = orderCreationDate;

    }


}

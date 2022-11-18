package com.gordeeva.courses.ShoesStore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cust_name")
    private String customerName;

    @Column(name = "cust_email")
    private String customerEmail;

    public CustomerEntity(String customerName, String customerEmail){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }
}

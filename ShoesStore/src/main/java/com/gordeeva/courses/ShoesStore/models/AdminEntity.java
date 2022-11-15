package com.gordeeva.courses.ShoesStore.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_fname")
    private String fname;

    @Column(name = "admin_lname")
    private String lname;

    private String admin_login;

    private String admin_password;
}

package com.gordeeva.courses.ShoesStore.dao;

import com.gordeeva.courses.ShoesStore.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity, Long> {
    public CustomerEntity getCustomerByCustomerEmailAndCustomerName(String email,String name);
}

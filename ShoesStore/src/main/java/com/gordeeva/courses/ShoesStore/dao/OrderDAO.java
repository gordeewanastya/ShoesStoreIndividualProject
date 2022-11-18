package com.gordeeva.courses.ShoesStore.dao;

import com.gordeeva.courses.ShoesStore.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity, Long> {

}

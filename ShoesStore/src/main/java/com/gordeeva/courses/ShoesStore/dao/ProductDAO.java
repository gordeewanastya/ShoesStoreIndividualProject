package com.gordeeva.courses.ShoesStore.dao;

import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<ProductEntity, Long> {
}

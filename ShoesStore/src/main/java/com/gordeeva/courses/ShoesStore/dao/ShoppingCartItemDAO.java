package com.gordeeva.courses.ShoesStore.dao;

import com.gordeeva.courses.ShoesStore.models.ShoppingCartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemDAO extends JpaRepository<ShoppingCartItemEntity, Long> {
}

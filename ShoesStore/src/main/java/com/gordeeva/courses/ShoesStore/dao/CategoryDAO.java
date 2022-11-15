package com.gordeeva.courses.ShoesStore.dao;


import com.gordeeva.courses.ShoesStore.models.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Long> {
}

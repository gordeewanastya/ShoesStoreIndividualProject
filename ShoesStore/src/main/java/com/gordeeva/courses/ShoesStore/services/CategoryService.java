package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.CategoryDAO;
import com.gordeeva.courses.ShoesStore.models.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryDAO categoryDAO;

    //get all categories from db
    public List<CategoryEntity> getAllSizeCategories(){
        List<CategoryEntity> categories = categoryDAO.findAll();
        return categories;
    }

    public CategoryEntity getCategoryById(Long id){
        Optional<CategoryEntity> optional = categoryDAO.findById(id);
        CategoryEntity categoryEntity = new CategoryEntity();
        if(optional.isPresent()){
            categoryEntity = optional.get();
        } else{
            throw new RuntimeException("Category not found for an id:: " + id);
        }
        return categoryEntity;
    }
}

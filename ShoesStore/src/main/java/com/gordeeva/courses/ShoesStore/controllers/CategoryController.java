package com.gordeeva.courses.ShoesStore.controllers;

import com.gordeeva.courses.ShoesStore.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    //create method to handle get request to read all categories from db
    @GetMapping("/get")
    public ResponseEntity<Object> getAllCategories(){
        try{
            return new ResponseEntity<>( categoryService.getAllSizeCategories(),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //get particular category from db
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }
}

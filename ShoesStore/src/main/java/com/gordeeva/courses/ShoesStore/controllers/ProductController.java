package com.gordeeva.courses.ShoesStore.controllers;

import com.gordeeva.courses.ShoesStore.models.dto.ProductDTO;
import com.gordeeva.courses.ShoesStore.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity<Object> getAllProducts(){
        try {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO productDTO){
        try {
            productService.addProduct(productDTO);
            return new ResponseEntity<>("The product was successfully added to the database",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // method that handles updating an existing product in DB
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id,@RequestBody ProductDTO productDTO){
        try {
            productService.updateProductById(id, productDTO);
            return new ResponseEntity<>("The product with id:: " + id +" was successfully updated in the database",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // method that handles request to delete an existing product from DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>("The product with id:: " + id +" was successfully deleted from the database",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

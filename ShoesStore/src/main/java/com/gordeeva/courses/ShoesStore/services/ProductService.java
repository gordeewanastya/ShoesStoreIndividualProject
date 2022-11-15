package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.ProductDAO;
import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import com.gordeeva.courses.ShoesStore.models.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    //get all existing products from DB

    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> products = new ArrayList<>();
        List<ProductEntity> productEntities = productDAO.findAll();
        for(ProductEntity productEntity: productEntities){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(productEntity.getId());
            productDTO.setName(productEntity.getName());
            productDTO.setPrice(productEntity.getPrice());
            productDTO.setQty(productEntity.getQty());
            productDTO.setSize_category(productEntity.getSize_category());
            productDTO.setCreatedAt(productEntity.getCreatedAt());

            //add to list with dtos we gonna return in response body
            products.add(productDTO);
        }
        return products;
    }

    //get a product by id provided in URL

    public ProductDTO getProductById(Long id){
        ProductDTO productDTO = new ProductDTO();
        Optional<ProductEntity> optional = productDAO.findById(id);
        ProductEntity productEntity = null;
        if(optional.isPresent()){
            productEntity = optional.get();
            productDTO.setId(productEntity.getId());
            productDTO.setName(productEntity.getName());
            productDTO.setPrice(productEntity.getPrice());
            productDTO.setQty(productEntity.getQty());
            productDTO.setSize_category(productEntity.getSize_category());
            productDTO.setCreatedAt(productEntity.getCreatedAt());
        }else {
            throw new RuntimeException("Product not found for an id:: " + id);
        }

        return productDTO;
    }

    //add new product to existing table in DB

    //update a product in existing DB

    //delete a product from existing DB

}

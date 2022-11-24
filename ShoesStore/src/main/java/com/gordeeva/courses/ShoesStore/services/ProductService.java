package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.ProductDAO;
import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import com.gordeeva.courses.ShoesStore.models.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    //get all existing products from DB

    public List<ProductDTO> getAllProducts(){

        logger.info("Entered method getAllProducts()");

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
            productDTO.setModifiedAt(productEntity.getModifiedAt());
            productDTO.setDeletedAt(productEntity.getDeletedAt());

            //add to list with DTOs we will return in response body
            products.add(productDTO);
        }

        logger.info("Returned list of DTO versions of product");

        return products;
    }

    //get a product by id provided in URL

    public ProductDTO getProductById(Long id){
        ProductDTO productDTO = new ProductDTO();
        Optional<ProductEntity> optional = productDAO.findById(id);
        ProductEntity productEntity = null;
        if(optional.isPresent()){

            logger.info("Product with id:: " + id+ " was successfully found.");

            productEntity = optional.get();
            productDTO.setId(productEntity.getId());
            productDTO.setName(productEntity.getName());
            productDTO.setPrice(productEntity.getPrice());
            productDTO.setQty(productEntity.getQty());
            productDTO.setSize_category(productEntity.getSize_category());
            productDTO.setCreatedAt(productEntity.getCreatedAt());
            productDTO.setModifiedAt(productEntity.getModifiedAt());

        }else {

            logger.error("Product with id:: " + id+ "doesn't exist in the DB");

            throw new RuntimeException("Product not found for an id:: " + id);
        }

        return productDTO;
    }

    //add new product to existing table in DB

    public void addProduct(ProductDTO productDTO){
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(productDTO.getName());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setQty(productDTO.getQty());
        newProduct.setSize_category(productDTO.getSize_category());

        logger.debug("Successfully saved new product to the DB");

        productDAO.save(newProduct);
    }



    //update a product in existing DB
    public void updateProductById(Long id, ProductDTO productDTO){
        Optional<ProductEntity> optional = productDAO.findById(id);
        ProductEntity productEntity = null;
        if(optional.isPresent()){
            productEntity = optional.get();
            productEntity.setName(productDTO.getName());
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setQty(productDTO.getQty());
            productDAO.save(productEntity);

            logger.info("Product with id:: " + id+ " was successfully updated.");

        }else{

            logger.error("Product with id:: " + id+ "doesn't exist in the DB");

            throw new RuntimeException("Couldn't update the product with id:: " + id +
                    "\nIt doesn't exist in the database");
        }
    }


    //delete a product from existing DB

    public void deleteProductById(Long id){
        Optional<ProductEntity> optional = productDAO.findById(id);
        ProductEntity productEntity = null;
        if(optional.isPresent()){ // check if the product we want to delete is actually in the database
            productEntity = optional.get();
            productDAO.delete(productEntity);

            logger.debug("Product with id:: " + id+ " was successfully deleted.");

        }else{
            logger.error("Product with id:: " + id+ "doesn't exist in the DB");

            throw new RuntimeException("Couldn't delete the product with id:: " + id +
                    "\nIt doesn't exist in the database");
        }
    }


    //Update qty of product after customer added it to the shopping cart ???probably change a little
    public void updateQtyAfterCustomerAddedProductToCart(Long productId, int itemInCartQty){
        Optional<ProductEntity> optional = productDAO.findById(productId);
        ProductEntity productEntity = null;
        ProductDTO productWithUpdatedQty = new ProductDTO();
        if(optional.isPresent()){ // check if the product we want to delete is actually in the database
            productEntity = optional.get();

            int updatedQty =  productEntity.getQty() - itemInCartQty;

            productWithUpdatedQty.setQty(updatedQty);
            productWithUpdatedQty.setName(productEntity.getName());
            productWithUpdatedQty.setPrice(productEntity.getPrice());


            updateProductById(productId, productWithUpdatedQty);

            // TODO: 11/18/22 try to update with custom query
            //productDAO.updateProdQty(updatedQty, productId);
        }else{
            throw new RuntimeException("Couldn't update the product qty with id:: " + productId +
                    "\nIt doesn't exist in the database");
        }
    }
}

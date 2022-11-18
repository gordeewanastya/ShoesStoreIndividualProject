package com.gordeeva.courses.ShoesStore.dao;

import com.gordeeva.courses.ShoesStore.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDAO extends JpaRepository<ProductEntity, Long> {


    //Partial update не работает почему то
//    //defining a custom query for partial update
//    @Modifying
//    @Query("update ProductEntity p set p.qty = :prodQty where p.id = :productId")
//    public void updateProdQty(@Param(value = "prodQty" )int prodQty,@Param(value = "productId" ) Long productId);


//    You have to define the method in Repository interface.and annotated it with @Query and @Modifying.

//    @Modifying
//    @Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
//    void setUserInfoById(String firstname, String lastname, Integer userId);

//    @Query is for defining custom query and @Modifying is for telling
//    spring-data-jpa that this query is an update operation and it requires executeUpdate() not executeQuery().
}

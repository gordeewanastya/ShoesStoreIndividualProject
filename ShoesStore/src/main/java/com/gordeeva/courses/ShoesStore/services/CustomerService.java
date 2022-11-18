package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.CustomerDAO;
import com.gordeeva.courses.ShoesStore.models.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;
//
//
//    //probably change return type to void
//    public CustomerEntity saveCustomer(CustomerEntity customer){
//        return customerDAO.save(customer);
//    }
//
//    //change to optional, name of the variable change
//    public Long isCustomerPresent(CustomerEntity customer){
//        CustomerEntity customer1 = customerDAO.getCustomerByCustomerEmailAndCustomerName(customer.getCustomerEmail(),customer.getCustomerName());
//        return customer1!=null ? customer1.getId(): null ;
//    }

}

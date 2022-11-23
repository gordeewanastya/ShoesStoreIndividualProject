package com.gordeeva.courses.ShoesStore.services;

import com.gordeeva.courses.ShoesStore.dao.CustomerDAO;
import com.gordeeva.courses.ShoesStore.models.CustomerEntity;
import com.gordeeva.courses.ShoesStore.models.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;


    public void saveCustomer(CustomerDTO customerDTO){
        try {
            CustomerEntity customer = new CustomerEntity();
            customer.setCustomerEmail(customerDTO.getEmail());
            customer.setCustomerName(customerDTO.getName());
            customerDAO.save(customer);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't save customer with such name:: " + customerDTO.getName());
        }
    };

    public List<CustomerEntity> getAllCustomers(){
        return customerDAO.findAll();
    }


    public CustomerEntity findById(Long id){
        Optional<CustomerEntity> customerOptional = customerDAO.findById(id);
        if (customerOptional.isPresent()){
            return customerOptional.get();
        } else {
            throw new RuntimeException("Couldn't find the customer with provided id:: " + id);
        }
    }




    //
//    public Long getCustomerIdUsingEmailAndName(String email, String name){
//        CustomerEntity customerFetchedByEmailAndName = customerDAO.getCustomerByCustomerEmailAndCustomerName(email,name);
//        if(customerFetchedByEmailAndName != null){
//            return customerFetchedByEmailAndName.getId();
//        }else{
//            saveNewCustomer(email, name);
//            return -1L;
//        }
//    }

//    //save customer to the db
//    // TODO: 11/22/22 must return customerId if it's present and must return either id if we just saved customer
//    public String saveCustomerByNameAndEmail(CustomerEntity customer){
//        //check if there is no such customer already
//        CustomerEntity customerEntity =  customerDAO.getCustomerByCustomerEmailAndCustomerName(
//                customer.getCustomerEmail(),
//                customer.getCustomerName()
//        );
//        if (customerEntity != null){
//            //then such customer already exists
//            //take his id
//            // TODO: 11/22/22 return id of existing customer
//            return "There is already such customer in the DB";
//        }else{
//            customerDAO.save(customer);
//            // TODO: 11/22/22 return id of just saved customer
//            return "Successfully saved customer with provided email and name";
//        }
//    }

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

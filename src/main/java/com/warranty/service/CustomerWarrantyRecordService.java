package com.warranty.service;

import com.warranty.exception.CustomerNotFountException;
import com.warranty.pojo.Customer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Slf4j
public class CustomerClaimRecordService {

    @Resource
    private CustomerClaimRecordService recordService;

    // Create new Customer RA
    public Customer createCustomerClaim(Customer customer){

        recordService.save(customer);

        customer.setCreated(Instant.now().toString());
        log.info("New Customer has been created =" +customer);

        return customer;
    }

    // Update Customer RA information
    public Customer updateCustomer(Customer customer, String customerCode){

        Customer exitingCustomer = recordService.findById(customerCode)
                .orElseThrow(()-> new ClassCastException("Customer not found with Customer Code = "+customerCode));
        customer.setIndexNumber(exitingCustomer.getIndexNumber());
        customer.setCustomerCode(exitingCustomer.getCustomerCode());
        customer.setUpdated(Instant.now().toString());
        recordService.save(customer);
        log.info("Customer has been updated with Customer Code = "+ customerCode);

        return customer;
    }

    //Delete a Customer RA
    public boolean deleteCustomer(String customerCode){

        Customer existing = recordService.findById(customerCode)
                .orElseThrow(()->new CustomerNotFountException("Customer not found with Customer Code ="+customerCode));
        recordService.delete(existing);
        log.info("Customer has been deleted with Customer Code = " +customerCode);
        return true;
    }

    // List All Customer RAs.
    public List<Customer> listCustomer(){

        return recordService.findAll();
    }

    // find one Customer RA
    public Customer findCustomerByCODE (String customerCode){
        Customer foundCustomer = recordService.findById(customerCode)
                .orElseThrow(()-> new CustomerNotFountException("Customer not found with Customer Code = "+customerCode));
        return foundCustomer;
    }



}

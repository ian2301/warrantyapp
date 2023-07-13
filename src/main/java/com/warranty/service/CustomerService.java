package com.warranty.service;

import com.warranty.exception.CustomerNotFountException;
import com.warranty.pojo.Customer;
import com.warranty.repository.CustomerRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;


@Transactional
@Service
@Slf4j
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    // Create new Customer
    public Customer createCustomer(Customer customer){
        customer.setCreated(Instant.now().toString().substring(0,19));
        customer.setStatus("active");
        customerRepository.save(customer);

        log.info("New Customer has been created =" +customer);

        return customer;
    }

    // Update Customer information
    public Customer updateCustomer(Customer customer, String customerCode){

        Customer exitingCustomer = customerRepository.findById(customerCode)
                .orElseThrow(()-> new CustomerNotFountException("Customer not found with Customer Code = "+customerCode));
        customer.setIndexNumber(exitingCustomer.getIndexNumber());
        customer.setCustomerCode(exitingCustomer.getCustomerCode());
        customer.setUpdated(Instant.now().toString().substring(0,19));
        customerRepository.save(customer);
        log.info("Customer has been updated with Customer Code = "+ customerCode);

        return customer;
    }

    //Delete a Customer
    public boolean deleteCustomer(String customerCode){

        Customer existing = customerRepository.findById(customerCode)
                .orElseThrow(()->new CustomerNotFountException("Customer not found with Customer Code ="+customerCode));
        customerRepository.delete(existing);
        log.info("Customer has been deleted with Customer Code = " +customerCode);
        return true;
    }

    // List All Customer.
    public List<Customer> listCustomer(){

        return customerRepository.findAll();
    }

    // find one Customer
    public Customer findCustomerByCODE (String customerCode){
        Customer foundCustomer = customerRepository.findById(customerCode)
                .orElseThrow(()-> new CustomerNotFountException("Customer not found with Customer Code = "+customerCode));
        return foundCustomer;
    }

}

package com.warranty.controller;

import com.warranty.exception.CustomerNotFountException;
import com.warranty.exception.SupplierNotFoundException;
import com.warranty.pojo.Customer;
import com.warranty.pojo.Supplier;
import com.warranty.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer){
        Customer newCustomer = customerService.createCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{customerCode}")
    public ResponseEntity<Customer> updateSupplierInfo(@RequestBody Customer customer, @PathVariable String customerCode) throws CustomerNotFountException {
        Customer updatedCustomer = customerService.updateCustomer(customer,customerCode);
        return  ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Customer>> listAll(){
        return ResponseEntity.ok().body(customerService.listCustomer());
    }

    @GetMapping("/getbycode/{customerCode}")
    public ResponseEntity<Customer> findSupplierByCode(@PathVariable String customerCode) throws CustomerNotFountException{
        Customer customer = customerService.findCustomerByCODE(customerCode);

        return ResponseEntity.ok(customer);

    }

    @DeleteMapping("/delete/{customerCode}")
    public ResponseEntity deleteSupplierByCode(@PathVariable String customerCode)throws CustomerNotFountException {

        customerService.deleteCustomer(customerCode);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

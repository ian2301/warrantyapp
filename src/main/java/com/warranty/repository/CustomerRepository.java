package com.warranty.repository;

import com.warranty.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository <Customer,String> {
}

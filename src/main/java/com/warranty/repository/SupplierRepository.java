package com.warranty.repository;

import com.warranty.pojo.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,String> {
}

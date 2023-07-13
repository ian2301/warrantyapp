package com.warranty.service;

import com.warranty.exception.SupplierNotFoundException;
import com.warranty.pojo.Supplier;
import com.warranty.repository.SupplierRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class SupplierService {

    @Resource
    private SupplierRepository supplierRepository;

    // Create new Supplier
    public Supplier createSupplier(Supplier supplier){
        supplier.setCreated(Instant.now().toString().substring(0,19));
        supplier.setStatus("active");
        supplierRepository.save(supplier);

        log.info("New Supplier has been created =" +supplier);

        return supplier;
    }

    // Update Supplier information
    public Supplier updateSupplier(Supplier supplier, String supplierCode){

        Supplier exitingSupplier = supplierRepository.findById(supplierCode)
                .orElseThrow(()-> new SupplierNotFoundException("Supplier not found with Supplier Code = "+supplierCode));
        supplier.setIndexNumber(exitingSupplier.getIndexNumber());
        supplier.setSupplierCode(exitingSupplier.getSupplierCode());
        supplier.setUpdated(Instant.now().toString().substring(0,19));
        supplierRepository.save(supplier);

        return supplier;
    }

    //Delete a supplier
    public boolean deleteSupplier(String supplierCode){

        Supplier existing = supplierRepository.findById(supplierCode)
                .orElseThrow(()->new SupplierNotFoundException("Supplier not found with Supplier Code ="+supplierCode));
        supplierRepository.delete(existing);
        log.info("supplier has been deleted with supplier Code = " +supplierCode);
        return true;
    }

    // List All Supplier, sort by supplier code.
    public List<Supplier> listSuppliers(){

        return supplierRepository.findAll();
    }

    // find one supplier
    public Supplier findSupplierByCODE (String supplierCode){
        Supplier supplierFound = supplierRepository.findById(supplierCode)
                .orElseThrow(()-> new SupplierNotFoundException("Supplier not found with Supplier Code = "+supplierCode));
        return supplierFound;
    }
}

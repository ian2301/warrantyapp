package com.warranty.controller;

import com.warranty.exception.SupplierNotFoundException;
import com.warranty.pojo.Supplier;
import com.warranty.service.SupplierService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/supplier")
public class SuppliersController {

    @Resource
    private SupplierService service;

    @PostMapping("/create")
    public ResponseEntity<Supplier> createSupplier (@RequestBody  Supplier supplier){
        Supplier newSupplier = service.createSupplier(supplier);

        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }

    @PutMapping("/update/{supplierCode}")
    public ResponseEntity<Supplier> updateSupplierInfo(@RequestBody Supplier supplier, @PathVariable String supplierCode) throws SupplierNotFoundException {
        Supplier updatedSupplier = service.updateSupplier(supplier,supplierCode);
        return  ResponseEntity.ok(updatedSupplier);
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Supplier>> listAll(){
        return ResponseEntity.ok().body(service.listSuppliers());
    }

    @GetMapping("/getbycode/{supplierCode}")
    public ResponseEntity<Supplier> findSupplierByCode(@PathVariable String supplierCode) throws SupplierNotFoundException{
        Supplier supplier = service.findSupplierByCODE(supplierCode);

        return ResponseEntity.ok(supplier);

    }

    @DeleteMapping("/delete/{supplierCode}")
    public ResponseEntity deleteSupplierByCode(@PathVariable String supplierCode)throws SupplierNotFoundException{

       service.deleteSupplier(supplierCode);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

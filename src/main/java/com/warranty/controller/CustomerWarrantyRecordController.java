package com.warranty.controller;

import com.warranty.exception.ClaimRecordNotFoundException;
import com.warranty.pojo.CustomerWarrantyRecord;
import com.warranty.service.CustomerWarrantyRecordService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/warrantyrecord")
public class CustomerWarrantyRecordController {

    @Resource
    private CustomerWarrantyRecordService recordService;

    @PostMapping("/create")
    public ResponseEntity<CustomerWarrantyRecord> createRecord(@RequestBody CustomerWarrantyRecord warrantyRecord){

        recordService.createCustomerWarranty(warrantyRecord);
        return new ResponseEntity<>(warrantyRecord, HttpStatus.CREATED);
    }

    @PutMapping("/update/{RANumber}")
    public ResponseEntity<CustomerWarrantyRecord> updateRecord(@RequestBody CustomerWarrantyRecord warrantyRecord, @PathVariable String RANumber) throws ClaimRecordNotFoundException {
        CustomerWarrantyRecord existing = recordService.updateCustomer(warrantyRecord,RANumber);
        return  ResponseEntity.ok(existing);
    }

    @GetMapping("/listall")
    public ResponseEntity<List<CustomerWarrantyRecord>> listAllRecord (){
        return ResponseEntity.ok().body(recordService.listAllRAs());
    }

    @GetMapping("/getbycode/{RANumber}")
    public ResponseEntity<CustomerWarrantyRecord> foundOne (@PathVariable String RANumber)throws ClaimRecordNotFoundException{
        CustomerWarrantyRecord warrantyRecord =recordService.findRAByCODE(RANumber);
        return ResponseEntity.ok(warrantyRecord);
    }

    @DeleteMapping("/delete/{RANumber}")
    public ResponseEntity deleteOne(@PathVariable String RANumber)throws ClaimRecordNotFoundException{
        recordService.deleteRecordByRANumber(RANumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

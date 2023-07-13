package com.warranty.service;

import com.warranty.exception.ClaimRecordNotFoundException;
import com.warranty.pojo.CustomerWarrantyRecord;
import com.warranty.repository.CustomerWarrantyRecordRepository;
import com.warranty.util.NextRANumber;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerWarrantyRecordService {

    @Resource
    private CustomerWarrantyRecordRepository recordRepository;

    @Resource
    private NextRANumber nextRANumber;

    // Create new Customer RA
    public CustomerWarrantyRecord createCustomerWarranty(CustomerWarrantyRecord record){
        record.setDateCreated(Instant.now().toString().substring(0,19));
        record.setRaNumber(nextRANumber.generateNextRA());
        record.setRaStatus("open");
        recordRepository.save(record);
        log.info("New RA Number has been created =" +record);

        return record;
    }

    // Update Customer RA information
    public CustomerWarrantyRecord updateCustomer(CustomerWarrantyRecord record, String RANumber){

        CustomerWarrantyRecord exiting = recordRepository.findById(RANumber)
                .orElseThrow(()-> new ClaimRecordNotFoundException("RA Number not found with RA Number Code = "+RANumber));
        record.setIndexNumber(exiting.getIndexNumber());
        record.setRaNumber(exiting.getRaNumber());
        recordRepository.save(record);
        log.info("RA Number has been updated with RA Number = "+ RANumber);

        return record;
    }

    //Delete a Customer RA
    public boolean deleteRecordByRANumber(String RANumber){

        CustomerWarrantyRecord existing = recordRepository.findById(RANumber)
                .orElseThrow(()->new ClaimRecordNotFoundException("RA Number not found with RA Number Code ="+RANumber));
        recordRepository.delete(existing);
        log.info("RA Number has been deleted with Customer Code = " +RANumber);
        return true;
    }

    // List All Customer RAs.
    public List<CustomerWarrantyRecord> listAllRAs(){

        return recordRepository.findAll();
    }

    // find one Customer RA
    public CustomerWarrantyRecord findRAByCODE (String RANumber){
        CustomerWarrantyRecord warrantyRecord = recordRepository.findById(RANumber)
                .orElseThrow(()-> new ClaimRecordNotFoundException("RA Number not found with RA Number Code = "+RANumber));
        return warrantyRecord;
    }


}

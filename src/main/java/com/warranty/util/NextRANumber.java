package com.warranty.util;

import com.warranty.pojo.CustomerWarrantyRecord;
import com.warranty.repository.CustomerWarrantyRecordRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.IntSummaryStatistics;
import java.util.List;

@Component
public class NextRANumber {

    @Resource
    private CustomerWarrantyRecordRepository warrantyRecordRepository;

    public Integer generateNextRA(){

        List<CustomerWarrantyRecord> allRecord = warrantyRecordRepository.findAll();
        IntSummaryStatistics statistics = allRecord.stream()
                .map(CustomerWarrantyRecord::getRaNumber)
                .mapToInt((x)->x)
                .summaryStatistics();

        Integer RANumber = statistics.getMax();

        Integer nextRANumber;
        if(RANumber <0){
             nextRANumber = 1;
        }else {
             nextRANumber = RANumber+1;
        }
        return  nextRANumber;
    }
}

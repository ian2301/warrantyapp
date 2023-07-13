package com.warranty.repository;

import com.warranty.pojo.CustomerWarrantyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.IntSummaryStatistics;
import java.util.List;


public interface CustomerWarrantyRecordRepository extends JpaRepository<CustomerWarrantyRecord,String> {


}

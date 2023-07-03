package com.warranty.repository;

import com.warranty.pojo.CustomerClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerClaimRecordRepository extends JpaRepository<CustomerClaimRecord,String> {
}

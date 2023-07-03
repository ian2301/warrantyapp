package com.warranty.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ra_record")
public class CustomerClaimRecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Index_Number")
    private long indexNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RA_Number")
    private String  RANumber;

    @NonNull
    @Column(name = "Date_Created")
    private String dateCreated;

    @NonNull
    @Column(name = "Customer_Code")
    private String customerCode;

    @NonNull
    @Column(name = "Product_Name")
    private String productName;

    @NonNull
    @Column(name = "Product_Model_Number")
    private String productModelNumber;

    @NonNull
    @Column(name = "Faulty_Description")
    private String faultDescription;

    @Column(name = "Date_Closed")
    private String  dateClosed;

    @NonNull
    @Column(name = "RA_Status")
    private String RAStatus;

    @Column(name = "Supplier_code")
    private String supplierCode;

    @Column(name = "Supplier_RMA_Number")
    private String supplierRMANumber;

    @Column(name = "Date_Ship_To_Supplier")
    private String DateShipToSupplier;

    @Column(name = "Date_Received_From_Supplier")
    private String  dateReceivedFromSupplier;

    @Column(name = "RMA_Status")
    private String RMAStatus;

    @Column(name = "Notes")
    private String notes;


}

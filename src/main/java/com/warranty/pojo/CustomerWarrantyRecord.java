package com.warranty.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ra_record")
public class CustomerWarrantyRecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "Index_Number")
    private long indexNumber;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "RA_Number")
    private Integer  raNumber;

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

    @Column(name = "Faulty_Description")
    private String faultDescription;

    @Column(name = "Date_Closed")
    private String  dateClosed;

    @NonNull
    @Column(name = "RA_Status")
    private String raStatus;

    @Column(name = "Supplier_Code")
    private String supplierCode;

    @Column(name = "Supplier_RMA_Number")
    private String supplierRMANumber;

    @Column(name = "Date_Ship_To_Supplier")
    private String dateShipToSupplier;

    @Column(name = "Date_Received_From_Supplier")
    private String  dateReceivedFromSupplier;

    @Column(name = "RMA_Status")
    private String rmaStatus;

    @Column(name = "Notes")
    private String notes;


}

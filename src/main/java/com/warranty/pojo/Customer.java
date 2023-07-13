package com.warranty.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Index_Number")
    private Long indexNumber;

    @Id
    @Column(name = "Customer_Code")
    private String customerCode;

    @NonNull
    @Column(name = "Customer_Name")
    private String customerName;

    @NonNull
    @Column(name = "Company_Name")
    private String companyName;

    @NonNull
    @Column(name = "Phone_Number")
    private String phoneNumber;

    @NonNull
    @Column(name = "Email")
    private String email;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "created")
    private String  created;

    @Column(name = "updated")
    private String updated;


    @Column(name = "Status")
    private String status;




}

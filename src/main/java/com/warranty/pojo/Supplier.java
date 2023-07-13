package com.warranty.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Index_Number")
    private Long indexNumber;

    @Id
    @Column(name = "Supplier_Code")
    private String supplierCode;

    @NonNull
    @Column(name = "Supplier_Name")
    private String supplierName;

    @NonNull
    @Column(name = "Contact_Number")
    private String contactNumber;

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

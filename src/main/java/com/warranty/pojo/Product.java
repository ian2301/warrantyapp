package com.warranty.pojo;

import lombok.Data;

@Data
public class Product {
    private String productName;
    private String productDescription;
    private Supplier supplier;

}

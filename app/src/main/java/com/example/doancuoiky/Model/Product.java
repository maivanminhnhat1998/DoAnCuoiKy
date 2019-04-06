package com.example.doancuoiky.Model;

import java.io.Serializable;

public class Product implements Serializable {
    private int Id;
    private String ProductName;
    private String ProductPrice;

    public Product(int id, String productName, String productPrice) {
        Id = id;
        ProductName = productName;
        ProductPrice = productPrice;
    }
    public Product( String productName, String productPrice) {
        ProductName = productName;
        ProductPrice = productPrice;
    }
    public Product(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}

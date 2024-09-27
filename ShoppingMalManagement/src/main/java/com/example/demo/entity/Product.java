package com.example.demo.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    private String productName;
    private String category;
    private double price;

//    @OneToMany(mappedBy = "products") // 'products' references the Cart entity's property
//    private Cart carts;
    
    @ManyToOne
    private Cart carts;

    // Constructors, getters, and setters
    public Product() {
    }

    public Product(Long pId, String productName, String category, double price, Cart carts) {
        this.pId = pId;
        this.productName = productName;
        this.category = category;
        this.price = price;
       // this.carts = carts;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Cart getCarts() {
//        return carts;
//    }
//
//    public void setCarts(Cart carts) {
//        this.carts = carts;
//    }

  
}

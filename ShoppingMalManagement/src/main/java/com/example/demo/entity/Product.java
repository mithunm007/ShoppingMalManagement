package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	/*
	 * pId as primary key
	 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    private String productName;
    private String category;
    private double price;

    /*
     * carts references in product entity
     */
    
    @ManyToOne
    private Cart carts;

    /*
     * parameterized and default Constructors
     */
    
    public Product() {
    }

    public Product(Long pId, String productName, String category, double price) {
        this.pId = pId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
    
    /*
     * getters and setters
     */

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



  
}

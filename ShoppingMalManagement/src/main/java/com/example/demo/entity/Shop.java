package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    private String shopName;
    private String shopOwner;

    @ManyToOne
    private Mall mall;
    
    @OneToMany(mappedBy = "shop") 
    private List<Employee> employees;
    
    public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



    // Getters and Setters
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

//    public Mall getMall() {
//        return mall;
//    }
//
//    public void setMall(Mall mall) {
//        this.mall = mall;
//    }

    // Constructors
    public Shop(Long shopId, String shopName, String shopOwner, Mall mall) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopOwner = shopOwner;
       // this.mall = mall;
    }

    public Shop() {
    }
}

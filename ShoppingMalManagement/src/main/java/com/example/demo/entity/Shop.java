package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Shop {
	
	/*
	 * shopId declared as primary key
	 */
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    private String shopName;
    private String shopOwner;
    
    /*
     *Mall entity referenced as mall in Shop entity
     */

    @ManyToOne
    private Mall mall;
    
    /*
     * Employee references the shop entity as employees
     */
    
    @OneToMany(mappedBy = "shop") 
    private List<Employee> employees;
    
    /*
     *  Getters and Setters
     */
    
    public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
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

    /*
     *  parameterized and default Constructors
     */
    
    public Shop(Long shopId, String shopName, String shopOwner) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopOwner = shopOwner;
    }

    public Shop() {
    }
}

package com.example.demo.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mallId;

    private String mallName;
    private String mallLocation;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Shop shops;
    
//    @ManyToOne
//    @JoinColumn(name = "shop_id", referencedColumnName = "shopId")
//    private Shop shops;
    
    @OneToMany(mappedBy = "mall") // 'products' references the Cart entity's property
    private List<Shop> shops;
    
    @OneToMany(mappedBy = "mall") // 'products' references the Cart entity's property
    private List<Employee> employees;
    
    
    

    // Getters and Setters
    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }
    
    

    public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getMallLocation() {
        return mallLocation;
    }

    public void setMallLocation(String mallLocation) {
        this.mallLocation = mallLocation;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    // Constructors
    public Mall(Long mallId, String mallName, String mallLocation,List< Shop> shops) {
        this.mallId = mallId;
        this.mallName = mallName;
        this.mallLocation = mallLocation;
        this.shops = shops;
    }

    public Mall() {
    }
}

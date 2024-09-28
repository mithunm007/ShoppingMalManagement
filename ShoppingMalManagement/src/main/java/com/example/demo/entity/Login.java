package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Login {
	
	//userId declared as primary key
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    private String userName;
    
    // 'employees' references the login entity's property
    
    @OneToMany(mappedBy = "login") 
    private List<Employee> employees;

    // Getters and Setters
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    //parameterized and default constructors
    
	public Login(Long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Login() {
		super();
	}
    
}

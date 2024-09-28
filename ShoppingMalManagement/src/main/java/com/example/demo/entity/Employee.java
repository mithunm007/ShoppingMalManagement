package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	
	/*
	 * empId created as primary Key using @Id annotation
	 */
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;
    private String empRole;
    private double empSalary;
    
    /*
     * creating the references of Shop,Mall and Login
     */
    
    @ManyToOne
    private Shop shop;
    
    @ManyToOne
    private Mall mall;
    
    @ManyToOne
    private Login login;

    /*
     *  Getters and Setters
     */
    
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
    
    /*
     * default and parameterized constructors
     */

	public Employee(Long empId, String empName, String empRole, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRole = empRole;
		this.empSalary = empSalary;
	}

	public Employee() {
		super();
	}
    
}


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Guest {
	
	//guestId declared as primary key
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    private String guestName;

    // Getters and Setters
    
    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    
    //parameterized Constructor and default constructor

	public Guest(Long guestId, String guestName) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
	}

	public Guest() {
		super();
	}
    
}


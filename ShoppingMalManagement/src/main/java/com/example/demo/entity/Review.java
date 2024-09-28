package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	
	/*
	 * reviewId declared as primary key
	 */
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String reviewRemark;
    
    /*
     * guest references in review entity with guestId
     */

    @ManyToOne
    @JoinColumn(name = "guestId", nullable = false)
    private Guest guest;

    /*
     *  Getters and Setters
     */
    
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewRemark() {
        return reviewRemark;
    }

    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    
    /*
     * parameterized and default constructors
     */

	public Review(Long reviewId, String reviewRemark, Guest guest) {
		super();
		this.reviewId = reviewId;
		this.reviewRemark = reviewRemark;
		this.guest = guest;
	}

	public Review() {
		super();
	}
    
}

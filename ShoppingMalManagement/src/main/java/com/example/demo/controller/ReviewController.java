package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;

import java.util.List;

/**
 * This class serves as the RESTful API controller for managing review data.
 * It provides endpoints for retrieving, creating, updating, and deleting reviews.
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    /**
     * Injects the ReviewService bean into the controller for accessing review-related services.
     */
    @Autowired
    private ReviewService reviewService;

    /**
     * Handles GET requests to the root endpoint, returning a list of all reviews.
     *
     * @return A list of all reviews.
     */
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    /**
     * Handles GET requests to the endpoint with a specified ID, returning a single review.
     *
     * @param id The ID of the review to retrieve.
     * @return The review with the given ID, or a 404 Not Found response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    /**
     * Handles POST requests to the root endpoint, creating a new review.
     *
     * @param review The review object to create.
     * @return The created review object.
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }

    /**
     * Handles PUT requests to the endpoint with a specified ID, updating an existing review.
     *
     * @param id The ID of the review to update.
     * @param review The updated review object.
     * @return The updated review object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(id, review);
        return ResponseEntity.ok(updatedReview);
    }

    /**
     * Handles DELETE requests to the endpoint with a specified ID, deleting a review.
     *
     * @param id The ID of the review to delete.
     * @return A 204 No Content response indicating successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
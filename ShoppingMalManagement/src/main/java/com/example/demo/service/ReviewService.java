package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import java.util.List;

/**
 * This class serves as a service component for managing review data.
 * It provides methods for retrieving, creating, updating, and deleting review information.
 */
@Service
public class ReviewService {

    /**
     * Injects the ReviewRepository bean for interacting with the review data store (likely a database).
     */
    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Retrieves a list of all reviews from the repository.
     *
     * @return A list of all Review objects.
     */
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Retrieves a review by its ID from the repository.
     *
     * @param id The ID of the review to retrieve.
     * @return The Review object if found, or null if not found.
     */
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new review and saves it to the repository.
     *
     * @param review The Review object to create.
     * @return The created Review object.
     */
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    /**
     * Updates an existing review with the provided details.
     *
     * @param id The ID of the review to update.
     * @param updatedReview The updated Review object containing new details.
     * @return The updated Review object if successful, or null if the original review wasn't found.
     */
    public Review updateReview(Long id, Review updatedReview) {
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if (existingReview != null) {
            // Update only the review remark and guest information from the provided Review object
            existingReview.setReviewRemark(updatedReview.getReviewRemark());
            existingReview.setGuest(updatedReview.getGuest()); // Assuming `Guest` is another entity

            return reviewRepository.save(existingReview);
        }
        return null;
    }

    /**
     * Deletes a review from the repository based on its ID.
     *
     * @param id The ID of the review to delete.
     */
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
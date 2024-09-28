package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;

@SpringBootTest
class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    private Review review;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize sample data
        review = new Review(1L, "Great product!",null);
    }

    @Test
    void testCreateReview() {
        when(reviewRepository.save(review)).thenReturn(review);
        Review savedReview = reviewService.createReview(review);
        assertNotNull(savedReview);
        assertEquals(review.getReviewId(), savedReview.getReviewId());
    }

    @Test
    void testGetReviewById() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));
        Review foundReview = reviewService.getReviewById(1L);
        assertNotNull(foundReview);
        assertEquals(review.getReviewId(), foundReview.getReviewId());
    }

    @Test
    void testUpdateReview() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));
        review.setReviewRemark("Updated Remark");
        when(reviewRepository.save(review)).thenReturn(review);
        Review updatedReview = reviewService.updateReview(1L, review);
        assertNotNull(updatedReview);
        assertEquals("Updated Remark", updatedReview.getReviewRemark());
    }

    @Test
    void testDeleteReview() {
        doNothing().when(reviewRepository).deleteById(1L);
        reviewService.deleteReview(1L);
        verify(reviewRepository, times(1)).deleteById(1L);
    }
}


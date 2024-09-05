package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.Review;
import com.realestate.Real_Estate.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Create a new Review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get a Review by ID
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // Update a Review
    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setUrl(updatedReview.getUrl());
                    review.setRate(updatedReview.getRate());
                    review.setComments(updatedReview.getComments());
                    review.setReviewdate(updatedReview.getReviewdate());
                    review.setRealty(updatedReview.getRealty());
                    review.setCustomer(updatedReview.getCustomer());
                    return reviewRepository.save(review);
                })
                .orElseThrow(() -> new RuntimeException("Review not found with id " + id));
    }

    // Delete a Review by ID
    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new RuntimeException("Review not found with id " + id);
        }
    }
}


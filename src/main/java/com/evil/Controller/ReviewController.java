package com.evil.Controller;

import com.evil.Entity.Product;
import com.evil.Entity.Review;
import com.evil.Entity.User;
import com.evil.Exception.IllegalReviewException;
import com.evil.Exception.NoReviewsException;
import com.evil.Repository.ProductRepository;
import com.evil.Repository.ReviewRepository;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implements controller for reviews.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RequestMapping(path="/api/products/{id}/reviews")
@RestController
public class ReviewController {

    /**
     * User repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Product repository.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Review repository.
     */
    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Adds new review to a product.
     *
     * @param review    Review
     * @param id        Id of the product
     * @return          Added review
     */
    @RequestMapping(method = RequestMethod.POST, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Review> postReviews(@RequestBody Review review,
                                     @PathVariable("id") int id) {

        String userdetails = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userdetails);
        Product product = productRepository.findOne(id);

        // checks if product has reviews.
        if (product.getReviews().size() > 0) {
            // loops reviews to check that user's id does not match on any
            // review.
            for (Review review1 : product.getReviews()) {
                if (review1.getUser().getId() == user.getId()) {
                    throw new IllegalReviewException();
                }
            }
        }

        // add user to the review.
        review.setUser(user);
        reviewRepository.save(review);

        List<Review> reviews = product.getReviews();
        // add review to review list.
        reviews.add(review);
        // Set modified review list to product.
        product.setReviews(reviews);
        // save product.
        productRepository.save(product);

        return ResponseEntity.status(201).body(review);
    }

    /**
     * Deletes review from a product.
     *
     * @param id    Id of the review
     * @return      Deleted review
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Review> deleteReview(@PathVariable("id") int id) {

        String userdetails = (String) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userdetails);
        Product product = productRepository.findOne(id);
        List<Review> reviews = product.getReviews();

        // checks if product has reviews.
        if (product.getReviews().size() > 0) {
            Review reviewToDelete = null;
            // loops reviews to check that user's id matches with the review.
            // User can delete only his/her reviews.
            for (Review review1 : reviews) {
                if (review1.getUser().getId() == user.getId()) {
                    reviewToDelete = review1;
                }
            }

            if (reviewToDelete != null) {
                reviews.remove(reviewToDelete);
                reviewRepository.delete(reviewToDelete);
                product.setReviews(reviews);
                productRepository.save(product);

                return ResponseEntity.ok(reviewToDelete);
            } else {
                throw new NoReviewsException();
            }
        }

        throw new NoReviewsException();
    }
}
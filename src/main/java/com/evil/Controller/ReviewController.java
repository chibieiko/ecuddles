package com.evil.Controller;

import com.evil.Entity.Product;
import com.evil.Entity.Review;
import com.evil.Entity.User;
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
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0415
 * @since 1.7
 */

@RequestMapping(path="/api/products/{id}/reviews")
@RestController
public class ReviewController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping(method = RequestMethod.POST, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Review> postReviews(@RequestBody Review review,
                                     @PathVariable("id") int id) {

        String userdetails = (String) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userdetails);
        Product product = productRepository.findOne(id);

        // checks if product has reviews.
        if (product.getReviews().size() > 0) {
            // loops reviews to check that user's id does not match on any
            // review.
            for (Review review1 : product.getReviews()) {
                if (review1.getUser().getId() == user.getId()) {
                    throw
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

        return null;
    }
}
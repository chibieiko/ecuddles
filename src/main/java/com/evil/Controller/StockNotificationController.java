package com.evil.Controller;

import com.evil.Entity.*;
import com.evil.Exception.DuplicateNotificationException;
import com.evil.Exception.NotOutOfStockException;
import com.evil.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Implements controller for stock notifications.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RestController
@RequestMapping(path = "/api/notifications/{product}")
public class StockNotificationController {

    /**
     * User repository.
     */
    @Autowired
    private UserRepository users;

    /**
     * Product repository.
     */
    @Autowired
    private ProductRepository products;

    /**
     * Stock notification repository.
     */
    @Autowired
    private StockNotificationRepository notifications;

    /**
     * Adds notification for a product.
     *
     * @param productId     Product ID to add notification for
     * @return              Response
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNotification(@PathVariable("product") int productId) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = users.findByEmail(email);
        Product product = products.findOne(productId);

        notifications.findAll().forEach(stockNotification -> {
            if (stockNotification.getUser() == user &&
                    stockNotification.getProduct() == product) {
                throw new DuplicateNotificationException();
            }
        });

        if (product.getStock() == 0) {
            StockNotification stockNotification = new StockNotification();
            stockNotification.setProduct(product);
            stockNotification.setUser(user);

            notifications.save(stockNotification);

            return ResponseEntity.ok().build();
        } else {
            throw new NotOutOfStockException();
        }
    }
}

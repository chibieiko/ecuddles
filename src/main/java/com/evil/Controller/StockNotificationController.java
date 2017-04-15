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
 * Created by vili on 01/04/2017.
 */
@RestController
@RequestMapping(path = "/api/notifications/{product}")
public class StockNotificationController {
    @Autowired
    private UserRepository users;

    @Autowired
    private ProductRepository products;

    @Autowired
    private StockNotificationRepository notifications;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> getCart(@PathVariable("product") int productId) {
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

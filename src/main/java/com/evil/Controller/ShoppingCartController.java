package com.evil.Controller;

import com.evil.Entity.Product;
import com.evil.Entity.User;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vili on 01/04/2017.
 */
@RestController
@RequestMapping(path = "/api/cart")
public class ShoppingCartController {

    @Autowired
    private UserRepository users;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getCart() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return users.findByEmail(user.getUsername()).getShoppingCartProducts();
    }
}

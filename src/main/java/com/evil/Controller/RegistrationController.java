package com.evil.Controller;

import com.evil.Entity.User;
import com.evil.Exception.RegistrationError;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements controller for registration.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RestController
@RequestMapping(path = "/api/register")
public class RegistrationController {

    /**
     * User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Adds new user to the database.
     *
     * @param user  User to add
     * @return      Added user
     */
    @RequestMapping(method = RequestMethod.POST)
    public User registerNewUser(@RequestBody User user) {
        user.setRole("USER");

        return userRepository.save(user);
    }
}

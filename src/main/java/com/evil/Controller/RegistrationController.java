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
 * Created by vili on 01/04/2017.
 */

@RestController
@RequestMapping(path = "/api/register")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public User registerNewUser(@RequestBody User user) {
        user.setRole("USER");

        return userRepository.save(user);
    }
}

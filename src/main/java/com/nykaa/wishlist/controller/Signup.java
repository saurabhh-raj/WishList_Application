package com.nykaa.wishlist.controller;

import com.nykaa.wishlist.exception.ResourceNotFoundException;
import com.nykaa.wishlist.model.User;
import com.nykaa.wishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Signup {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public String Signup(@RequestBody User user) throws ResourceNotFoundException {
        return userService.createUser(user);

    }
}

package com.users.controller;

import com.users.entity.User;
import com.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    // GET http://localhost:9001/user/{userId}
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        // 1. Get user from local dummy data
        User user = userService.getUser(userId);

        // 2. Call ContactService to get contacts using RestTemplate
        List<?> contacts = restTemplate.getForObject(
                "http://localhost:9002/contact/user/" + userId,
                List.class
        );

        // 3. Set contacts in user object
        user.setContacts(contacts);

        return user;
    }

    // Optional: Handle root URL to avoid Whitelabel Error
    @GetMapping("/")
    public String home() {
        return "User Service is running on port 9001";
    }
}

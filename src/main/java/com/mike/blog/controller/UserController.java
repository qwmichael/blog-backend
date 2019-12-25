package com.mike.blog.controller;

import com.mike.blog.modal.User;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(@RequestBody String username, String password) {
        User user = userService.getUser(username);
        if (user != null && user.getPassword() == password) {
            return user.getToken();
        }
        return null;
    }

    @GetMapping(value = "/user")
    public User getUser(@RequestBody String token) {
        return userService.getUserByToken(token);
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody String username, String password) {
        User user = userService.getUser(username);
        System.out.print(username + " " + password);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setToken(UUID.randomUUID().toString());
            userService.addUser(user);
            return user.getToken();
        }
        return null;
    }


}

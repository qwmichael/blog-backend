package com.mike.blog.controller;

import com.mike.blog.modal.Blog;
import com.mike.blog.modal.User;
import com.mike.blog.service.BlogService;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(@RequestBody String username, @RequestBody String password) {
        User user = userService.getUser(username);
        if (user != null && user.getPassword() == password) {
            return user.getToken();
        }
        return null;
    }

    @GetMapping(value = "/register")
    public String register(@RequestBody String username, @RequestBody String password) {
        User user = userService.getUser(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setToken(UUID.randomUUID().toString());
            String token = UUID.randomUUID().toString();
            return user.getToken();
        }
        return null;
    }


}

package com.mike.blog.controller;

import com.mike.blog.modal.User;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
/**
 * This is the controller for registration and login.
 *
 * @author Michael Ng
 *
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(@RequestBody User user) {
        User temp = userService.getUser(user.getUsername());
        if (temp != null && user.getPassword().equals(temp.getPassword())) {
            return temp.getToken();
        }
        return null;
    }

    @GetMapping(value = "/user")
    public User getUser(@RequestBody String token) {
        return userService.getUserByToken(token);
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User user) {
        String username = user.getUsername();
        if (userService.getUser(username) == null) {
            user.setToken(UUID.randomUUID().toString());
            userService.addUser(user);
            return user.getToken();
        }
        return null;
    }


}

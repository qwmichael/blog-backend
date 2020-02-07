package com.mike.blog.controller;

import com.mike.blog.modal.User;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.UUID;
/**
 * This is the controller for registration and login.
 *
 * @author Michael Ng
 *
 */

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public HashMap<String, String> login(@Valid @NonNull @RequestBody User user) {
        User temp = userService.getUser(user.getUsername());
        HashMap<String, String> map = new HashMap<>();
        if (temp != null && user.getPassword().equals(temp.getPassword())) {
            map.put("Token", temp.getToken());
            return map;
        }
        map.put("Token", null);
        return map;
    }

    @GetMapping(value = "/user")
    public User getUser(@RequestBody String token) {
        System.out.println();
        return userService.getUserByToken(token);
    }

    @PostMapping(value = "/register")
    public HashMap<String, String> register(@RequestBody User user) {
        String username = user.getUsername();
        HashMap<String, String> map = new HashMap<>();
        if (userService.getUser(username) == null && !username.isEmpty() && !user.getPassword().isEmpty()) {
            String id = UUID.randomUUID().toString();
            while(userService.getUserByToken(id) != null) {
                id = UUID.randomUUID().toString();
            }
            user.setToken(id);
            userService.addUser(user);
            map.put("Token", user.getToken());
            return map;
        }
        map.put("Token", null);
        return map;
    }


}

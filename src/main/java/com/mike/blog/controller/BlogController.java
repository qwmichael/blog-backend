package com.mike.blog.controller;

import com.mike.blog.modal.Blog;
import com.mike.blog.service.BlogService;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/blog")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @PostMapping(value = "/blog")
    public void addBlog(@RequestBody Blog blog, String token) {
        blog.setCreator(userService.getUser(token).getUsername());
        blogService.addBlog(blog);
    }
}

package com.mike.blog.controller;

import com.mike.blog.modal.Blog;
import com.mike.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/blog")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @PostMapping(value = "/blog")
    public void addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
    }
}

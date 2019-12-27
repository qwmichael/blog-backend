package com.mike.blog.controller;

import com.mike.blog.modal.Blog;
import com.mike.blog.service.BlogService;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This is the controller for the crud operation of blog
 *
 * @author Michael Ng
 *
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    /**
     * @return the list of blog from the system
     */
    @GetMapping(value = "/blog")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    /**
     * @param token the user identifier
     * @param blog the blog in a json format
     */
    @PostMapping(value = "/blog")
    public void addBlog(@RequestParam String token, @RequestBody Blog blog) {
        blog.setCreator(userService.getUserByToken(token).getUsername());
        blogService.addBlog(blog);
    }

    @DeleteMapping(value = "/blog")
    public void deleteBlog(@RequestParam String token, @RequestBody long id) {
        if (userService.getUserByToken(token).getUsername().equals(blogService.getBlog(id).getCreator())) blogService.removeBlog(id);
    }
}

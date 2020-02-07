package com.mike.blog.controller;

import com.mike.blog.modal.Blog;
import com.mike.blog.service.BlogService;
import com.mike.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * This is the controller for the crud operation of blog
 *
 * @author Michael Ng
 *
 */
@RequestMapping("blog")
@RestController
public class BlogController {

    private BlogService blogService;
    private UserService userService;

    @Autowired
    public BlogController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }

    /**
     * @return the list of blog from the system
     */
    @GetMapping()
    public List<Blog> getBlog() {
        return blogService.getBlog();
    }

    @GetMapping(path = "{id}")
    public Blog getBlogById(@PathVariable("id") long id) {
        return blogService.getBlog(id).orElse(null);
    }

    /**
     * @param token the user identifier
     * @param blog the blog in a json format
     */
    @PostMapping()
    public void addBlog(@RequestParam String token, @RequestBody Blog blog) {
        blog.setCreator(userService.getUserByToken(token).getUsername());
        blogService.addBlog(blog);
    }

    @DeleteMapping()
    public void deleteBlog(@RequestParam String token, @RequestBody long id) {
        if (userService.getUserByToken(token).getUsername().equals(blogService.getBlog(id).get().getCreator())) blogService.removeBlog(id);
    }

    @PutMapping()
    public void UpdateBlog(@RequestParam String token, @Valid @RequestBody Blog blog) {
        if (userService.getUserByToken(token).getUsername().equals(blog.getCreator())) blogService.updateBlog(blog);
    }
}

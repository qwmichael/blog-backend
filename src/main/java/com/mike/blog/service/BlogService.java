package com.mike.blog.service;

import com.mike.blog.modal.Blog;
import com.mike.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * This is the service for blog
 *
 * @author Michael Ng
 *
 */
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Blog getBlog(long id) {
       return blogRepository.findBlogById(id);
    }

    public void removeBlog(long id) {
        blogRepository.delete(blogRepository.findBlogById(id));
    }
}

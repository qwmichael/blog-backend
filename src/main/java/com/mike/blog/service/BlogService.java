package com.mike.blog.service;

import com.mike.blog.modal.Blog;
import com.mike.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is the service for blog
 *
 * @author Michael Ng
 *
 */
@Service
public class BlogService {

    private BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getBlog() {
        return blogRepository.findAll();
    }

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Optional<Blog> getBlog(long id) {
       return blogRepository.findBlogById(id);
    }

    public void removeBlog(long id) {
        blogRepository.deleteById(id);
    }

    public void updateBlog(Blog blog) {
        blogRepository.deleteById(blog.getId());
        blogRepository.save(blog);
    }
}

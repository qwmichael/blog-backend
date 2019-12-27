package com.mike.blog.repository;

import com.mike.blog.modal.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This is the repository for blog
 *
 * @author Michael Ng
 *
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findBlogById(long id);
}

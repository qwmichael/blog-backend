package com.mike.blog.repository;

import com.mike.blog.modal.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This is the repository for blog
 *
 * @author Michael Ng
 *
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Optional<Blog> findBlogById(long id);
    void deleteById(Long aLong);
}

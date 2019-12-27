package com.mike.blog.repository;

import com.mike.blog.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * This is the repository for user
 *
 * @author Michael Ng
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByToken(String token);
    User findByUsername(String username);
}

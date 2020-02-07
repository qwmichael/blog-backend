package com.mike.blog.service;

import com.mike.blog.modal.User;
import com.mike.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * This is the service for user
 *
 * @author Michael Ng
 *
 */
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) { return userRepository.findByUsername(username); }
    public User getUserByToken(String token) { return userRepository.findByToken(token); }
    public void addUser(User user) { userRepository.save(user); }
}

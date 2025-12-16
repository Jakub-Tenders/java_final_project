package com.epita.airline.service;

import com.epita.airline.dao.UserDAO;
import com.epita.airline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // Get all users
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // Get user by ID
    public User getUserById(Long id) {
        return userDAO.findById(id);
    }

    // Add a new user
    public User addUser(User user) {
        userDAO.save(user);
        return user; // Return the same user object
    }

    // Update an existing user
    public User updateUser(Long id, User user) {
        userDAO.update(id, user);
        return user;
    }

    // Delete a user
    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
}

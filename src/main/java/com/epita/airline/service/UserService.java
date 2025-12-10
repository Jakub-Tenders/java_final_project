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

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUser(Long id) {
        return userDAO.findById(id);
    }

    public void addUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(Long id, User user) {
        userDAO.update(id, user);
    }

    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
}

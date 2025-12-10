package com.epita.airline.controller;

import com.epita.airline.model.User;
import com.epita.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // Create a new user
    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.addUser(user);
        return "User created successfully!";
    }

    // Update a user
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return "User updated successfully!";
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully!";
    }
}

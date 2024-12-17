package com.example.sem8.service;

import com.example.sem8.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
}

package com.example.sem8.service;

import com.example.sem8.aspects.Track;
import com.example.sem8.model.User;
import com.example.sem8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {
    private  final UserRepository repository;


    @Override
    @Track
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    @Track
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    @Track
    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    @Track
    public User updateUser(User user) {
        User userId = user;
        userId.setName(user.getName());
        userId.setBirthday(user.getBirthday());
        userId.setMarried(user.getMarried());
        return repository.save(userId);
    }

    @Override
    @Track
    public void deleteUser(Long id) {
        User us = getUserById(id);
        repository.delete(us);
    }
}

package com.example.sem8.controller;

import com.example.sem8.model.User;
import com.example.sem8.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class UserController {
    private final UserServiceImpl service;

    @PostMapping
    public User createUser(User user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED).getBody();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK).getBody();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User userId;
        try{
            userId = service.getUserById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User()).getBody();
        }
        return new ResponseEntity<>(userId, HttpStatus.OK).getBody();
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        user.setId(id);
        return new ResponseEntity<>(service.updateUser(user), HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        ResponseEntity.ok().build();
    }

}

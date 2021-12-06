package com.searchengine.MongoDB.controllers;

import java.util.Optional;

import com.searchengine.MongoDB.models.User;
import com.searchengine.MongoDB.repositories.UserRepo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/mongodb/api")

public class UserController {
    @Autowired
    UserRepo repo;  

    @PostMapping("/user")
    public ResponseEntity<User> createContact(@RequestBody User user) {
        try {
            User _UserRepo = repo
                    .save(new User(user.getId(), user.getUsername(), user.getEmail(), user.getPassword()));
            return new ResponseEntity<>(_UserRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.searchengine.MongoDB.repositories;

import java.util.List;

import com.searchengine.MongoDB.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    List<User> findByUsername(String username);
}

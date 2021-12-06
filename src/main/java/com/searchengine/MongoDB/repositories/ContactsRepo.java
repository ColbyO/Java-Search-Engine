package com.searchengine.MongoDB.repositories;

import java.util.List;
import java.util.Optional;

import com.searchengine.MongoDB.models.Contacts;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactsRepo extends MongoRepository<Contacts, String> {
    Optional<Contacts> findById(long id);
    List<Contacts> findByFirstName(String firstName);
}

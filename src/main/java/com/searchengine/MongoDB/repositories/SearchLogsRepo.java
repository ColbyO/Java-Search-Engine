package com.searchengine.MongoDB.repositories;

import java.util.List;
import java.util.Optional;

import com.searchengine.MongoDB.models.SearchLogs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface SearchLogsRepo extends MongoRepository<SearchLogs, Long> {
    Optional<SearchLogs> findById(long id);
    List<SearchLogs> findByUsername(String username);
}

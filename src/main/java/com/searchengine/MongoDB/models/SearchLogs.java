package com.searchengine.MongoDB.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;

public class SearchLogs {
    @Id
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "searchTerm")
    private String searchTerm;
    @Column(name = "searchQuery")
    private String searchQuery;
    @Column(name = "database")
    private String database;
    @Column(name = "createdAt")
    private LocalDate createdAt;

    public SearchLogs() {}

    public SearchLogs(long id, String username, String searchTerm, String searchQuery,String database, LocalDate createdAt) {
        this.id = id;
        this.username = username;
        this.searchTerm = searchTerm;
        this.searchQuery = searchQuery;
        this.database = database;
        this.createdAt = createdAt;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSearchTerm() {
        return this.searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchQuery() {
        return this.searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public String getDatabase() {
        return this.database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}

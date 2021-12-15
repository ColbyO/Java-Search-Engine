package com.searchengine.MongoDB.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "search")
    private String search;
    @Column(name = "searchQuery")
    private String searchQuery;
    @Column(name = "database")
    private String database;
    @Column(name = "createdAt")
    private String createdAt;

    public SearchLogs() {}

    public SearchLogs(long id, String username, String search, String searchQuery, String database, String createdAt) {
        this.id = id;
        this.username = username;
        this.search = search;
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

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String search) {
        this.search = search;
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

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

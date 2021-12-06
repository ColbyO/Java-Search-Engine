package com.searchengine.MongoDB.models;

import org.springframework.security.crypto.bcrypt.*;

public class User {
    private long id;

    private String username;

    private String password;

    private String hashedPassword = BCrypt.hashpw(this.password, BCrypt.gensalt(10));

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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkPass(String password) {
        if(BCrypt.checkpw(password, this.hashedPassword)) {
            System.out.println("Password Match");
        } else {
            System.out.println("No Match");
        }
    }


}

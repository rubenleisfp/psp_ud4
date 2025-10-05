package com.fp.api_client.comments.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

// Clase interna para User
public class User {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String username;
    private String fullName;

    public User() {}

    // Constructor
    public User(int id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
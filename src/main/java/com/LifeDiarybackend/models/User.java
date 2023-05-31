package com.LifeDiarybackend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String username;
    private String password;



    @OneToMany
    private Set<Collection> collections;



    public User() {
    }

    public User(String username, String Password) {
        this.username = username;
        this.password = password;
        this.collections = new HashSet<>();
    }

    public Set<Collection> getCollections() {
        return collections;
    }

    public void addCollection(Collection collection) {
        this.collections.add(collection);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



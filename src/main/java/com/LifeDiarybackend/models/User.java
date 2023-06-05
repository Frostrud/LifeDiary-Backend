package com.LifeDiarybackend.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String firstName;
    private String lastName;
    private String membership;
    private String email;
    private String password;



    @OneToMany
    private Set<Collection> collections;



    public User() {
    }

    public User(String firstName, String lastName, String membership, String email, String Password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.membership = membership;
        this.email = email;
        this.password = password;
        this.collections = new HashSet<>();
    }

    public Set<Collection> getCollections() {
        return collections;
    }

    public void addCollection(Collection collection) {
        this.collections.add(collection);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMembership() {
        return membership;
    }
}



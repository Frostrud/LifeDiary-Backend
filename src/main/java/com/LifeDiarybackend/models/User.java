package com.LifeDiarybackend.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;



    private String username;
    private String password;

    public User() {
    }

    public User(String username, String Password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}



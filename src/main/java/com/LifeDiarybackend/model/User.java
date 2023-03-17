package com.LifeDiarybackend.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "Users")
public class User {

    @Id
    private Long userId;
    private String username;
    private String password;

    @ElementCollection
    private ArrayList<String> collectionIDs;

    public User() {
        this.collectionIDs = new ArrayList<>();
    }
}



package com.LifeDiarybackend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;



    private String collectionName;



    @OneToMany
    private Set<Text> texts;

    public Collection() {
    }

    public Collection(User user, String name) {
        this.user = user;
        this.texts = new HashSet<Text>();
        this.collectionName = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Text> getTexts() {
        return texts;
    }

    public void addText(Text text) {
        this.texts.add(text);
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}

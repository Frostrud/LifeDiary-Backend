package com.LifeDiarybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    private User user;

    private String collectionName;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Text> texts;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Image> images;

    public Collection() {
    }

    public Collection(User user, String name) {
        this.user = user;
        this.collectionName = name;
        this.texts = new HashSet<Text>();
        this.images = new HashSet<Image>();
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

    public User getUser() {
        return user;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }
}

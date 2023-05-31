package com.LifeDiarybackend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Collections")
public class Collection {
    @Id
    private Long id;

    @ManyToOne
    private User user;



    @OneToMany
    private Set<Text> texts;

    public Collection() {
    }

    public Collection(User user) {
        this.user = user;
        this.texts = new HashSet<Text>();
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
}

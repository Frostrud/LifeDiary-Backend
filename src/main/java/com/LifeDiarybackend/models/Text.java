package com.LifeDiarybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Texts")
public class Text {

    @Id
    private Long id;
    private String headLine;

    private String content;

    @ManyToOne
    private Collection collection;


    public Text() {}

    public Text(Collection collection, String headLine, String content) {
        this.collection = collection;
        this.headLine = headLine;
        this.content = content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

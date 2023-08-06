package com.LifeDiarybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Texts")
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String headLine;

    private String content;

    @JsonIgnore
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

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}

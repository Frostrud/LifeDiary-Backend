package com.LifeDiarybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Base64;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonIgnore
    @Lob
    private byte[] data;

    @Column(length = 10000)
    private String base64Data = "";

    @JsonIgnore
    @ManyToOne
    private Collection collection;

    public Image(){
    }

    public Image(String name, byte[] data, Collection collection) {
        this.name = name;
        this.data = data;
        this.collection = collection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }

    public void encodeDataToBase64() {
        this.base64Data = Base64.getEncoder().encodeToString(this.data);
    }

    public void emptyBase64() {
        setBase64Data("");
    }
}

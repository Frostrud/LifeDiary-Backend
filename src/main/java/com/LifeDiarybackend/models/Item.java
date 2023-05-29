package com.LifeDiarybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    private Long itemID;
    private String itemName;

    public Item() {}
}

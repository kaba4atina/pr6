package com.example.myapp.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey
    public int id;
    public String title;
    public String subtitle;
    public String description;
    public int imageRes;


    public Item(
            int id,
            String description,
            String subtitle,
            String title,
            int imageRes
    ) {
        this.id = id;
        this.description = description;
        this.subtitle = subtitle;
        this.title = title;
        this.imageRes = imageRes;
    }
}

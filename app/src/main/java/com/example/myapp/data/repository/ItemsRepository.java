package com.example.myapp.data.repository;

import com.example.myapp.data.datasource.AnotherDataSource;
import com.example.myapp.data.datasource.FirstDataSource;
import com.example.myapp.data.model.Item;

import java.util.ArrayList;

public class ItemsRepository {
    public ArrayList<Item> getItems() {
        return FirstDataSource.getItems();
    }

    public ArrayList<Item> getAnotherItems() {
        return AnotherDataSource.getAnotherItems();
    }

    public Item getById(int id) {
        for (Item user : FirstDataSource.getItems()) {
            if (user.id == id) {
                return user;
            }
        }
        for (Item user : AnotherDataSource.getAnotherItems()) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
}

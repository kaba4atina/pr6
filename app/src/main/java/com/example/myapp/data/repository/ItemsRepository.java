package com.example.myapp.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.data.datasource.AnotherDataSource;
import com.example.myapp.data.datasource.FirstDataSource;
import com.example.myapp.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepository {
    public MutableLiveData<List<Item>> getItems(Application application) {
        return FirstDataSource.getItems(application);
    }

    public ArrayList<Item> getAnotherItems() {
        return AnotherDataSource.getAnotherItems();
    }

    public Item getById(int id, Application application) {
        for (Item user : FirstDataSource.getItems(application).getValue()) {
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

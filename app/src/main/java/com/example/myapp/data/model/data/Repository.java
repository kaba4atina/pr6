package com.example.myapp.data.model.data;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class Repository {
    public ArrayList<User> getUsers() {
        return SimpleDataSource.getUsers();
    }

    public User getUser(int id) {
        for (User user : SimpleDataSource.getUsers()) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
}


package com.example.myapp.data.datasource;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.R;
import com.example.myapp.data.ItemsDao;
import com.example.myapp.data.MyDatabase;
import com.example.myapp.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class FirstDataSource {
    public static MutableLiveData<List<Item>> getItems(Application app) {
        MutableLiveData<List<Item>> usersLiveData = new MutableLiveData<>();

        ItemsDao dao = MyDatabase.getDataBase(app).dao();
        MyDatabase.databaseWriterExecutor.execute(() -> {
            List<Item> items = dao.getAllItems();
            if (items.isEmpty()) {
                for (int i = 0; i < 200; i++) {
                    dao.insert(new Item(
                            i,
                            "description of simple item" + (i + 1),
                            "subtitle of simple item" + (i + 1),
                            "title of simple item" + (i + 1),
                            R.drawable.ic_android_black_24dp
                    ));
                }
            }
            usersLiveData.postValue(dao.getAllItems());
        });

        return usersLiveData;
    }
}

package com.example.myapp.data.datasource;

import com.example.myapp.R;
import com.example.myapp.data.model.Item;

import java.util.ArrayList;

public class FirstDataSource {
    public static ArrayList<Item> getItems() {
        ArrayList<Item> list = new ArrayList<Item>();
        for (int i = 300; i < 500; i++) {
            list.add(
                    new Item(
                            i,
                            "description of simple item" + (i + 1),
                            "subtitle of simple item" + (i + 1),
                            "title of simple item" + (i + 1),
                            R.drawable.ic_android_black_24dp
                    )
            );
        }
        return list;
    }
}

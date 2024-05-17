package com.example.myapp.data.datasource;

import com.example.myapp.R;
import com.example.myapp.data.model.Item;

import java.util.ArrayList;

public class AnotherDataSource {
    public static ArrayList<Item> getAnotherItems() {
        ArrayList<Item> list = new ArrayList<Item>();
        for (int i = 0; i < 200; i++) {
            list.add(
                    new Item(
                            i,
                            "description of another item" + (i + 1),
                            "subtitle of another item" + (i + 1),
                            "title of another item" + (i + 1),
                            R.drawable.baseline_emoji_emotions_24
                    )
            );
        }
        return list;
    }
}

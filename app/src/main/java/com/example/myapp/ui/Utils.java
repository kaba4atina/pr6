package com.example.myapp.ui;

import com.example.myapp.R;
import com.example.myapp.data.model.Item;

import java.util.ArrayList;

public class Utils {
    public static final String EXTRA_KEY = "EXTRA_KEY";
    public static final String MY_TAG = "MY_TAG";
    public static final String RESULT_KIY = "MY_TAG";
    public static final String BUNDLE_KEY = "BUNDLE_KEY";
    public static final String REQUEST_KEY = "REQUEST_KEY";
    public static final String CHILD_REQUEST_KEY = "CHILD_REQUEST_KEY";

    public static final String BUNDLE_STRING_KEY = "BUNDLE_STRING_KEY";

    public static ArrayList<Item> getListViewItems() {
        ArrayList<Item> list = new ArrayList<Item>();
        for (int i = 0; i < 200; i++) {
            list.add(
                    new Item(
                            i,
                            "description of item" + (i + 1),
                            "subtitle of item" + (i + 1),
                            "title of item" + (i + 1),
                            R.drawable.ic_android_black_24dp
                    )
            );
        }
        return list;
    }
}

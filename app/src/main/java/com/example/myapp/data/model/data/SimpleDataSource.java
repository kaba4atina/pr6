package com.example.myapp.data.model.data;

import java.util.ArrayList;

public class SimpleDataSource {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.id = i;
            user.firstName = "FirstName" + i;
            user.secondName = "SecondName" + i;
            user.age = String.valueOf(20 + i);
            user.detailsInformation = "Details Information about " + user.firstName;
            users.add(user);

        }
        return users;
    }
}

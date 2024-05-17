package com.example.myapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapp.data.model.Item;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Item.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract ItemsDao dao();

    public static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(1);

    public static volatile MyDatabase INSTANCE;

    public static MyDatabase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDatabase.class, "mydatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


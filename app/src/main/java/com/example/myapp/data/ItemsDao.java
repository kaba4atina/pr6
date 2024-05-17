package com.example.myapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapp.data.model.Item;

import java.util.List;

@Dao
public interface ItemsDao {
    @Query("SELECT * FROM item")
    List<Item> getAllItems();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Item entity);
}

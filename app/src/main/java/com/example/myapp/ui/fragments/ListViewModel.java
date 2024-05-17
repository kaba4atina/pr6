package com.example.myapp.ui.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.data.model.Item;
import com.example.myapp.data.repository.ItemsRepository;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    private ItemsRepository itemsRepository;
    private final MutableLiveData<ArrayList<Item>> activeItems = new MutableLiveData<>();

    public LiveData<ArrayList<Item>> getActiveItemsLiveData() {
        return activeItems;
    }

    public ListViewModel() {
        itemsRepository = new ItemsRepository();
        activeItems.setValue(itemsRepository.getItems());
    }

    public void setFirstItemsActive() {
        activeItems.setValue(itemsRepository.getItems());
    }
    public void setAnotherItemsActive() {
        activeItems.setValue(itemsRepository.getAnotherItems());
    }
}

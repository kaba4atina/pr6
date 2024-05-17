package com.example.myapp.ui.fragments;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.data.model.Item;
import com.example.myapp.data.repository.ItemsRepository;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    private ItemsRepository itemsRepository;
    private MutableLiveData<List<Item>> activeItems = new MutableLiveData<>();

    public LiveData<List<Item>> getActiveItemsLiveData() {
        return activeItems;
    }

    private Application application = null;
    public void setApplication(Application application) {
        this.application = application;
    }

    public ListViewModel() {
        itemsRepository = new ItemsRepository();
        activeItems = itemsRepository.getItems(application);
    }

    public void setFirstItemsActive() {
        activeItems = itemsRepository.getItems(application);
    }
    public void setAnotherItemsActive() {
        activeItems.setValue(itemsRepository.getAnotherItems());
    }
}

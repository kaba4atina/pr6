package com.example.myapp.ui.fragments;

import android.telephony.ims.ImsMmTelManager;
import android.text.SegmentFinder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.data.model.Item;
import com.example.myapp.data.repository.ItemsRepository;

public class DetailsViewModel extends ViewModel {
    private MutableLiveData<Item> selectedItem = new MutableLiveData<Item>();

    private ItemsRepository repository;

    DetailsViewModel() {
        repository = new ItemsRepository();
    }

    public void updateSelected(int id) {
        Item newItem = repository.getById(id);
        selectedItem.setValue(newItem);
    }

    public LiveData<Item> getSelectedItemLiveData() {
        return selectedItem;
    }
}

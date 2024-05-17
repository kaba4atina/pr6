package com.example.myapp.data.model.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserDetailViewMode extends ViewModel {

    private Repository repository;
    public MutableLiveData<User> user = new MutableLiveData<>();

    public UserDetailViewMode() {
        repository = new Repository();
    }

    public void updateUser(int userId) {
        user.setValue(repository.getUser(userId));
    }
}

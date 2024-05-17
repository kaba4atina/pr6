package com.example.myapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.data.model.Item;
import com.example.myapp.ui.Utils;
import com.example.myapp.ui.adapters.RecycleViewAdapter;
import com.example.myapp.databinding.FragmentRecycleViewBinding;

import java.util.ArrayList;

public class RecycleViewFragment extends Fragment {
    private FragmentRecycleViewBinding binding = null;
    private ListViewModel vm = null;
    private Boolean isCurrentItemsFirst = true;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecycleViewBinding.inflate(getLayoutInflater());

        vm = new ViewModelProvider(this).get(ListViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = binding.recyclerView;
        RecycleViewAdapter adapter = new RecycleViewAdapter(new ArrayList<>(), requireContext());
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        rv.setAdapter(adapter);

        binding.changeItems.setOnClickListener(v -> {
            if (isCurrentItemsFirst) vm.setAnotherItemsActive();
            else vm.setFirstItemsActive();
            isCurrentItemsFirst = !isCurrentItemsFirst;
        });

        vm.getActiveItemsLiveData().observe(
                getViewLifecycleOwner(),
                adapter::setNewData
        );
    }
}
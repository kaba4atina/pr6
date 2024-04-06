package com.example.myapp.fragments.pr4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.Utils;
import com.example.myapp.adapters.RecycleViewAdapter;
import com.example.myapp.databinding.FragmentRecycleViewBinding;

public class RecycleViewFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRecycleViewBinding binding = FragmentRecycleViewBinding.inflate(getLayoutInflater());

        RecyclerView rv = binding.recyclerView;
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        rv.setAdapter(new RecycleViewAdapter(Utils.getListViewItems(), requireContext()));

        return binding.getRoot();
    }
}
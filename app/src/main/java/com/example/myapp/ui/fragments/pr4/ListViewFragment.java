package com.example.myapp.ui.fragments.pr4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.ui.Utils;
import com.example.myapp.ui.adapters.ListViewAdapter;
import com.example.myapp.databinding.FragmentListViewBinding;

public class ListViewFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListViewBinding binding = FragmentListViewBinding.inflate(getLayoutInflater());

        ListView listView = binding.listView;
        ListViewAdapter adapter = new ListViewAdapter(
                requireContext(),
                R.layout.item_layout,
                Utils.getListViewItems()
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, v, position, id) -> {
            Toast.makeText(requireContext(), "on list item click", Toast.LENGTH_SHORT).show();
        });


        return binding.getRoot();
    }
}
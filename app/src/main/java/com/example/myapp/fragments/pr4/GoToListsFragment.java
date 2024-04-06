package com.example.myapp.fragments.pr4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.databinding.FragmentGoToListsBinding;

public class GoToListsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentGoToListsBinding binding = FragmentGoToListsBinding.inflate(getLayoutInflater());

//        binding.goToListViewFragmentButton.setOnClickListener(view -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .replace(
//                            R.id.main_fragment_container,
//                            ListViewFragment.class,
//                            null
//                    )
//                    .addToBackStack(null)
//                    .commit();
//        });
//
//        binding.goToRecycleViewFragmentButton.setOnClickListener(view -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .replace(
//                            R.id.main_fragment_container,
//                            RecycleViewFragment.class,
//                            null
//                    )
//                    .addToBackStack(null)
//                    .commit();
//        });

        return binding.getRoot();
    }
}
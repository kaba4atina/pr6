package com.example.myapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.data.ExternalStorageUtils;
import com.example.myapp.databinding.FragmentItemDetailsBinding;
import com.example.myapp.databinding.FragmentRecycleViewBinding;

public class ItemDetailsFragment extends Fragment {

    private DetailsViewModel vm = null;
    private FragmentItemDetailsBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentItemDetailsBinding.inflate(getLayoutInflater());
        ExternalStorageUtils.saveToExternalStorage("myFile2.txt", "my data");
        vm = new ViewModelProvider(this).get(DetailsViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            vm.updateSelected(bundle.getInt("Item"));
        }

        vm.getSelectedItemLiveData().observe(getViewLifecycleOwner(), item -> {
            binding.itemId.setText(""+item.id);
            binding.itemTitle.setText(item.title);
            binding.itemSubtitle.setText(item.subtitle);
            binding.itemDesc.setText(item.description);
            binding.itemImage.setImageDrawable(requireContext().getDrawable(item.imageRes));
        });
    }
}
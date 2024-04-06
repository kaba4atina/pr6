package com.example.myapp.fragments.pr5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.Utils;
import com.example.myapp.databinding.FragmentPR5ThirdBinding;

public class PR5ThirdFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPR5ThirdBinding binding = FragmentPR5ThirdBinding.inflate(getLayoutInflater());

        Bundle bundle = getArguments();
        if (bundle != null) {
            binding.dataTextView.setText(bundle.getString(Utils.BUNDLE_STRING_KEY));
        }

        binding.navigateToFirstButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_PR5SecondFragment_to_PR5FirstFragment);
        });

        return binding.getRoot();
    }
}
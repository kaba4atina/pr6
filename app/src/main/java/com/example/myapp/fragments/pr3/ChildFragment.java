package com.example.myapp.fragments.pr3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.Utils;
import com.example.myapp.databinding.FragmentChildBinding;


public class ChildFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChildBinding binding = FragmentChildBinding.inflate(getLayoutInflater());

        binding.imageView1.setImageDrawable(requireContext().getDrawable(R.drawable.image1));

        binding.sendButton.setOnClickListener(view -> {
            Bundle result = new Bundle();
            result.putString(Utils.BUNDLE_KEY, "Результат переданный от дочернего фрагмента");
            getParentFragmentManager().setFragmentResult(Utils.CHILD_REQUEST_KEY, result);
        });

        return binding.getRoot();
    }
}
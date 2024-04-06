package com.example.myapp.fragments.pr3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.Utils;
import com.example.myapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.second_fragment_container,
                            ChildFragment.class,
                            null
                    )
                    .commit();
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(getLayoutInflater());

        setParentFragmentResultListener(binding);
        setChildFragmentResultListener(binding);

        binding.imageView2.setImageDrawable(requireContext().getDrawable(R.drawable.image2));

        return binding.getRoot();
    }

    private void setChildFragmentResultListener(FragmentSecondBinding binding) {
        getChildFragmentManager()
                .setFragmentResultListener(Utils.CHILD_REQUEST_KEY, this, ((requestKey, result) -> {
                    binding.extraTextView.setText(result.getString(Utils.BUNDLE_KEY));
                }));
    }

    private void setParentFragmentResultListener(FragmentSecondBinding binding) {
        getParentFragmentManager().setFragmentResultListener(Utils.REQUEST_KEY,
                this, (requestKey, bundle) -> {
                    String result = bundle.getString(Utils.BUNDLE_KEY);
                    binding.extraTextView.setText(result);
                });
    }
}
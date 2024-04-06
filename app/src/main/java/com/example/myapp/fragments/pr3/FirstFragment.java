package com.example.myapp.fragments.pr3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.Utils;
import com.example.myapp.databinding.FragmentFirstBinding;
import com.example.myapp.fragments.pr4.ListViewFragment;

public class FirstFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(Utils.MY_TAG, "FirstFragment onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Utils.MY_TAG, "FirstFragment onCreate");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(Utils.MY_TAG, "FirstFragment onCreateView");
        FragmentFirstBinding binding = FragmentFirstBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(view -> {
            toSecondFragment();
        });

        return binding.getRoot();
    }

    private void toSecondFragment() {
        Bundle result = new Bundle();
        result.putString(Utils.BUNDLE_KEY, "Результат от фрагмента FirstFragment");
        getParentFragmentManager().setFragmentResult(
                Utils.REQUEST_KEY, result);
//        resultrequireActivity().getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .replace(
//                        R.id.main_fragment_container,
//                        ListViewFragment.class,
//                        null
//                )
//                .addToBackStack(null)
//                .commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(Utils.MY_TAG, "FirstFragment onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(Utils.MY_TAG, "FirstFragment onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Utils.MY_TAG, "FirstFragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Utils.MY_TAG, "FirstFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Utils.MY_TAG, "FirstFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Utils.MY_TAG, "FirstFragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(Utils.MY_TAG, "FirstFragment onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Utils.MY_TAG, "FirstFragment onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Utils.MY_TAG, "FirstFragment onDetach");
    }
}
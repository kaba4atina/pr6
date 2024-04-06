package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapp.databinding.ActivityMainBinding;
import com.example.myapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        binding.imageView1.setImageDrawable(getDrawable(R.drawable.image1));
        binding.imageView2.setImageDrawable(getDrawable(R.drawable.image2));

        binding.extraTextView.setText(intent.getStringExtra(Utils.EXTRA_KEY));
    }


}
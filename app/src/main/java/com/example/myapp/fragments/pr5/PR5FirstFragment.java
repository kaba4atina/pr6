package com.example.myapp.fragments.pr5;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.Utils;
import com.example.myapp.databinding.FragmentPR5FirstBinding;

public class PR5FirstFragment extends Fragment {

    private final String ID = "channel_id_example_01";
    private final int notificationId = 101;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Канал";
            String description = "Описание";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager)requireContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPR5FirstBinding binding = FragmentPR5FirstBinding.inflate(getLayoutInflater());

        Bundle bundle = new Bundle();
        bundle.putString(Utils.BUNDLE_STRING_KEY, "Данные от первого фрагмента");

        binding.navigateToSecondButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(
                    R.id.action_PR5FirstFragment_to_PR5SecondFragment
            );
        });

        binding.navigateToThirdButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(
                    R.id.action_PR5FirstFragment_to_PR5ThirdFragment,
                    bundle
            );
        });

        binding.showNotificationButton.setOnClickListener(view -> {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Пример уведомления")
                    .setContentText("Это пример уведомления с текстом.")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
                return;
            notificationManager.notify(notificationId, builder.build());
        });

        return binding.getRoot();
    }
}

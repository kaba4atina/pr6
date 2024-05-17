package com.example.myapp.data;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorageUtils {
    public static void saveToExternalStorage(String fileName, String data) {
        String externalStorageState = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(externalStorageState)) return;
        try {
            FileOutputStream stream = new FileOutputStream(
                    new File(
                            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                            fileName
                    )
            );
            stream.write(data.getBytes());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

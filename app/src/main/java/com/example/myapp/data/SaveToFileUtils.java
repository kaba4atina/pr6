package com.example.myapp.data;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;

public class SaveToFileUtils {
    public static void saveToFile(Context context, String dataToSave, String file) {
        FileOutputStream fileStream = null;
        try {
            fileStream = context.openFileOutput(file, Context.MODE_PRIVATE);
            fileStream.write(dataToSave.getBytes());
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

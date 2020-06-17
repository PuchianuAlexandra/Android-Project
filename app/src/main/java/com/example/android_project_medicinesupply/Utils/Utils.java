package com.example.android_project_medicinesupply.Utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;

        try {
            InputStream stream = context.getAssets().open(fileName);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

}

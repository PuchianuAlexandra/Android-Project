package com.example.android_project_medicinesupply.Utils;

import android.app.Application;

import androidx.room.Room;

import com.example.android_project_medicinesupply.Database.AppDatabase;

public class AppController extends Application {

    private static AppController controller;
    private AppDatabase database;

    public static AppController getInstance() {
        return controller;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        controller = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();
    }

    public AppDatabase getDatabaseInstance() {
        return database;
    }
}

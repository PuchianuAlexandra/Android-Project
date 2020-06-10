package com.example.android_project_medicinesupply.Database;

import androidx.room.Database;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase {

    public abstract UserDao userDao();
}

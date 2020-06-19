package com.example.android_project_medicinesupply.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Medicine.class, Order.class, MedicineOrder.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}

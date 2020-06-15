package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    User selectUser(String email, String password);
}

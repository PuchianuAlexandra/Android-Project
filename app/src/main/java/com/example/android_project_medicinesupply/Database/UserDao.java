package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    User selectUserByEmailAndPassword(String email, String password);

    @Query("SELECT * FROM user WHERE  id = :id")
    User selectUserById(int id);

    @Query("SELECT * FROM user WHERE email = :email ")
    User selectUserByEmail(String email);
}

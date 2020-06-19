package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User user);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    public User selectUserByEmailAndPassword(String email, String password);

    @Query("SELECT * FROM user WHERE  id = :id")
    public User selectUserById(int id);

    @Query("SELECT * FROM user WHERE email = :email ")
    public User selectUserByEmail(String email);
}

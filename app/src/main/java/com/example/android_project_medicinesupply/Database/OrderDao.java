package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrderDao {

    @Insert
    void insertOrder(Order order);

    @Query("SELECT * FROM Orders")
    List<Order> selectOrder();

    @Query("SELECT id FROM Orders ORDER BY id DESC LIMIT 1")
    int selectLastOrder();
}

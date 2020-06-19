package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrderDao {

    @Insert
    public void insertOrder(Order order);

    @Query("SELECT * FROM Orders")
    public List<Order> selectOrders();

    @Query("SELECT id FROM Orders ORDER BY id DESC LIMIT 1")
    public int selectLastOrder();
}

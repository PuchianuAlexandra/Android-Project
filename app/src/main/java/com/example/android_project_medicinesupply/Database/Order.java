package com.example.android_project_medicinesupply.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Orders")
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user")
    private int userId;

    public Order() {
        id = 0;
        userId = 0;
    }

    public Order(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

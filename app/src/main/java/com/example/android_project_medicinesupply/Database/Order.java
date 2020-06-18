package com.example.android_project_medicinesupply.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user")
    private int userId;
    private List<Medicine> medicines;

    public Order() {
        id = 0;
        userId = 0;
        medicines = new ArrayList<>();
    }

    public Order(int id, int userId, List<Medicine> medicines) {
        this.id = id;
        this.userId = userId;
        this.medicines = medicines;
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

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}

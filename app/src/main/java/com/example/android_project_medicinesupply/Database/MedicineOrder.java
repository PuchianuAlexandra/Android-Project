package com.example.android_project_medicinesupply.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MedicineOrder {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "idOrder")
    private int idOrder;
    @ColumnInfo(name = "idMedicine")
    private int idMedicine;

    public MedicineOrder(int idOrder, int idMedicine) {
        this.idOrder = idOrder;
        this.idMedicine = idMedicine;
    }

    public MedicineOrder() {
        this.id = 0;
        this.idOrder = 0;
        this.idMedicine = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }
}

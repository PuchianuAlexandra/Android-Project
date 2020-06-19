package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicineOrderDao {

    @Insert
    public void insertMedicineOrder(MedicineOrder medicineOrder);

    @Query("SELECT * FROM MedicineOrder WHERE idOrder=:idOrder")
    public List<MedicineOrder> selectMedicines(int idOrder);
}

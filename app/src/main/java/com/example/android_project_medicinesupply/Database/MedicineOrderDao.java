package com.example.android_project_medicinesupply.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicineOrderDao {
    @Insert
    void insertMedicineOrder(MedicineOrder medicineOrder);

    @Query("SELECT * FROM MedicineOrder WHERE idOrder=:idOrder")
    List<MedicineOrder> selectMedicines(int idOrder);
}

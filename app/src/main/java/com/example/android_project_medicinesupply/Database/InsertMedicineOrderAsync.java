package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class InsertMedicineOrderAsync extends AsyncTask<MedicineOrder, Void, Void> {
    @Override
    protected Void doInBackground(MedicineOrder... medicineOrders) {
        AppController.getInstance().getDatabaseInstance().medicineOrderDao().insertMedicineOrder(medicineOrders[0]);
        return null;
    }
}

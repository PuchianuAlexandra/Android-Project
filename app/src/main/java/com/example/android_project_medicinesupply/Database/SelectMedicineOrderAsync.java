package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

import java.util.List;

public class SelectMedicineOrderAsync extends AsyncTask<Integer, Void, List<MedicineOrder>> {

    @Override
    protected List<MedicineOrder> doInBackground(Integer... integers) {
        List<MedicineOrder> medicineOrders = AppController.getInstance().getDatabaseInstance().medicineOrderDao().selectMedicines(integers[0]);
        return medicineOrders;
    }

    @Override
    protected void onPostExecute(List<MedicineOrder> medicineOrders) {
        super.onPostExecute(medicineOrders);
    }
}

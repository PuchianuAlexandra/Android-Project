package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class SelectMedicineAsync extends AsyncTask<Integer, Void, Medicine> {

    @Override
    protected Medicine doInBackground(Integer... integers) {
        Medicine medicine = AppController.getInstance().getDatabaseInstance().medicineDao().selectMedicine(integers[0]);
        return medicine;
    }

    @Override
    protected void onPostExecute(Medicine medicine) {
        super.onPostExecute(medicine);
    }
}

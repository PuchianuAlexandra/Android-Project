package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class InsertMedicineAsync extends AsyncTask<Medicine, Void, Void> {

    @Override
    protected Void doInBackground(Medicine... medicines) {
        AppController.getInstance().getDatabaseInstance().medicineDao().insertMedicine(medicines[0]);
        return null;
    }
}

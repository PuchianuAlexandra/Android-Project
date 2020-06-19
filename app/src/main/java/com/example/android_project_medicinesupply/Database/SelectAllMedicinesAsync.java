package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

import java.util.List;

public class SelectAllMedicinesAsync extends AsyncTask<Void,Void, List<Medicine>> {
    @Override
    protected List<Medicine> doInBackground(Void... voids) {
        List<Medicine> medicineList = AppController.getInstance().getDatabaseInstance().medicineDao().selectAllMedicines();
        return medicineList;
    }

    @Override
    protected void onPostExecute(List<Medicine> medicines) {
        super.onPostExecute(medicines);
    }
}

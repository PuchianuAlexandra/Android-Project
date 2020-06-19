package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class UpdateQuantityAsync extends AsyncTask<Medicine, Void, Void> {
    @Override
    protected Void doInBackground(Medicine... medicines) {
        int id = medicines[0].getId();
        int newQuantity = medicines[0].getQuantity() + 1;
        AppController.getInstance().getDatabaseInstance().medicineDao().updateQuantity(newQuantity, id);
        return null;
    }
}

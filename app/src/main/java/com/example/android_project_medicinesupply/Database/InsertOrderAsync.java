package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class InsertOrderAsync extends AsyncTask<Order, Void, Integer> {
    @Override
    protected Integer doInBackground(Order... orders) {
        AppController.getInstance().getDatabaseInstance().orderDao().insertOrder(orders[0]);
        int id = AppController.getInstance().getDatabaseInstance().orderDao().selectLastOrder();
        return id;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}

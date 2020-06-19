package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

import java.util.List;

public class SelectOrdersAsync extends AsyncTask<Void, Void, List<Order>> {

    @Override
    protected List<Order> doInBackground(Void... voids) {
        List<Order> orders = AppController.getInstance().getDatabaseInstance().orderDao().selectOrders();
        return orders;
    }

    @Override
    protected void onPostExecute(List<Order> orders) {
        super.onPostExecute(orders);
    }
}

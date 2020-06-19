package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class SelectUserByIdAsync extends AsyncTask<Integer, Void, User> {

    @Override
    protected User doInBackground(Integer... integers) {
        User user = AppController.getInstance().getDatabaseInstance().userDao().selectUserById(integers[0]);
        return user;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
    }
}

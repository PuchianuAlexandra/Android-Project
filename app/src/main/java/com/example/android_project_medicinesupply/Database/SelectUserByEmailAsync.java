package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class SelectUserByEmailAsync extends AsyncTask<String, Void, User> {

    @Override
    protected User doInBackground(String... strings) {
        User user = AppController.getInstance().getDatabaseInstance().userDao().selectUserByEmail(strings[0]);
        return user;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
    }
}

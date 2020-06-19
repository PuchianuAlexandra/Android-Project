package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class SelectUserByEmailAndPasswordAsync extends AsyncTask<String,Void,User> {

    @Override
    protected User doInBackground(String... params) {
        User user = AppController.getInstance().getDatabaseInstance().userDao().selectUserByEmailAndPassword(params[0],params[1]);
        return user;
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
    }
}


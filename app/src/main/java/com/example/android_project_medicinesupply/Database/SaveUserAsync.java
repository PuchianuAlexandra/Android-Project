package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class SaveUserAsync extends AsyncTask<User,Void,Void> {
    @Override
    protected Void doInBackground(User... users) {
        AppController.getInstance().getDatabaseInstance().userDao().insertUser(users[0]);
        return null;
    }
}

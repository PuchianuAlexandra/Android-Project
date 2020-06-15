package com.example.android_project_medicinesupply.Database;

import android.os.AsyncTask;

import com.example.android_project_medicinesupply.Utils.AppController;

public class SaveUserAsync extends AsyncTask<User,Void,Void> {
    @Override
    protected Void doInBackground(User... users) {
        User user = users[0];
        AppController.getInstance().getDatabaseInstance().userDao().insertUser(user);
        return null;
    }
}

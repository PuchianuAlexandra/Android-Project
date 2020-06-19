package com.example.android_project_medicinesupply.Activities;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_project_medicinesupply.Database.SelectUserByEmailAndPasswordAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.Fragments.UserFragment;
import com.example.android_project_medicinesupply.R;

import java.util.concurrent.ExecutionException;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        User user = new User();
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        AsyncTask<String, Void, User> userAsyncTask = new SelectUserByEmailAndPasswordAsync().execute(email, password);

        try {
            user = userAsyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentFrame, new UserFragment(user));
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }
}
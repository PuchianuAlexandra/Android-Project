package com.example.android_project_medicinesupply.Activities;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_project_medicinesupply.Database.SelectUserByEmailAndPasswordAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.Fragments.InventoryFragment;
import com.example.android_project_medicinesupply.R;

import java.util.concurrent.ExecutionException;

public class InventoryActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        user = new User();
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        AsyncTask<String, Void, User> asyncTask = new SelectUserByEmailAndPasswordAsync().execute(email, password);

        try {
            user = asyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentFrame, new InventoryFragment(user));
        transaction.commit();
    }
}

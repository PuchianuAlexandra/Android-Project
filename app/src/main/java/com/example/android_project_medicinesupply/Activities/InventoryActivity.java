package com.example.android_project_medicinesupply.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_project_medicinesupply.Database.User;

public class InventoryActivity extends AppCompatActivity {

    private User user;

    public InventoryActivity(User user) {
        this.user = user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Intent intent=getIntent();
        user=intent.getParcelableExtra("user");
        Toast toast = Toast.makeText(getApplicationContext(), user.getName(), Toast.LENGTH_LONG);
        toast.show();
    }
}

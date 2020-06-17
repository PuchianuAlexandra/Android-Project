package com.example.android_project_medicinesupply.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;

public class InventoryActivity extends AppCompatActivity {

    private User user;

   /* public InventoryActivity(User user) {
        this.user = user;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        user = new User();
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        user.setEmail(email);
        user.setPassword(password);

        Toast toast = Toast.makeText(getApplicationContext(), user.getEmail(), Toast.LENGTH_LONG);
        toast.show();
    }
}

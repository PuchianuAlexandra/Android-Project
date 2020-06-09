package com.example.android_project_medicinesupply.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    Button btnSeePassword;
    TextInputEditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View view = getLayoutInflater().inflate(R.layout.activity_login, null);
        btnSeePassword = view.findViewById(R.id.btnSeePassword);
        txtPassword = view.findViewById(R.id.txtPassword);

        btnSeePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPassword.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                else if(txtPassword.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                    txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
    }

    /*private InputType changePasswordVisibility(InputType receivedInput)
    {
        InputType returnedInput;

        if(receivedInput == InputType.TYPE_TEXT_VARIATION_PASSWORD)
            txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        else if(txtPassword.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }*/
}

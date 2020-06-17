package com.example.android_project_medicinesupply.Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_project_medicinesupply.Activities.InventoryActivity;
import com.example.android_project_medicinesupply.Database.SelectUserAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.ExecutionException;

public class LoginFragment extends Fragment {

    private CheckBox checkSeePassword;
    private TextInputEditText txtEmail;
    private TextInputEditText txtPassword;
    private Button btnAddAccount;
    private Button btnLogIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        checkSeePassword = view.findViewById(R.id.checkSeePassword);
        txtPassword = view.findViewById(R.id.txtPassword);
        txtEmail = view.findViewById(R.id.txtEmail);
        btnAddAccount = view.findViewById(R.id.btnAddAccount);
        btnLogIn = view.findViewById(R.id.btnLogin);

        checkSeePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentFrame, new NewAccountFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                AsyncTask<String, Void, User> asyncTask = new SelectUserAsync().execute(txtEmail.getText().toString(), txtPassword.getText().toString());

                try {
                    user = asyncTask.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (user == null) {
                    Toast toast = Toast.makeText(getContext(), R.string.no_user_found, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Intent intent = new Intent(getActivity(), InventoryActivity.class);
                    intent.putExtra("email", user.getEmail());
                    intent.putExtra("password", user.getPassword());
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}

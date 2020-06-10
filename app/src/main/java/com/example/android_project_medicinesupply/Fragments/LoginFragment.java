package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {

    CheckBox checkSeePassword;
    TextInputEditText txtPassword;
    Button btnCreateAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        checkSeePassword = view.findViewById(R.id.checkSeePassword);
        txtPassword = view.findViewById(R.id.txtPassword);
        btnCreateAccount = view.findViewById(R.id.btnCreateAccount);

        checkSeePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentFrame, new NewAccountFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }


}

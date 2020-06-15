package com.example.android_project_medicinesupply.Fragments;

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

import com.example.android_project_medicinesupply.Database.SaveUserAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewAccountFragment extends Fragment {

    TextInputEditText txtPassword;
    TextInputEditText txtConfirmPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_new_account, container, false);
        Button btnCreateAccount=view.findViewById(R.id.btnCreateAccount);
        Button btnCancel=view.findViewById(R.id.btnCancel);
        CheckBox seePassword=view.findViewById(R.id.checkSeePassword);
        txtPassword=view.findViewById(R.id.txtPassword);
        txtConfirmPassword=view.findViewById(R.id.txtConfirmPassword);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity().getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    getActivity().getSupportFragmentManager().popBackStackImmediate();
                }
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText txtName=view.findViewById(R.id.txtName);
                TextInputEditText txtTelephone=view.findViewById(R.id.txtTelephone);
                TextInputEditText txtEmail=view.findViewById(R.id.txtEmail);
               if(!validateTelephone(txtTelephone.getText().toString())){
                    Toast toast=Toast.makeText(getContext(), R.string.invalid_telephone,Toast.LENGTH_LONG);
                }else if(!validateEmail(txtEmail.getText().toString())){
                    Toast toast=Toast.makeText(getContext(), R.string.invalid_email,Toast.LENGTH_LONG);
                }else if(txtPassword.getText().toString()!=txtConfirmPassword.getText().toString()){
                    Toast toast=Toast.makeText(getContext(), R.string.invalid_password,Toast.LENGTH_LONG);
                }else{
                    User user=new User(txtName.getText().toString(),txtEmail.getText().toString(),txtPassword.getText().toString(),txtTelephone.getText().toString());
                    AsyncTask<User,Void,Void> asyncTask=new SaveUserAsync().execute(user);
                    Toast toast=Toast.makeText(getContext(), R.string.account_created,Toast.LENGTH_LONG);
                    if(getActivity().getSupportFragmentManager().getBackStackEntryCount() != 0) {
                        getActivity().getSupportFragmentManager().popBackStackImmediate();
                    }
                }

            }
        });

        seePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    txtConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    txtConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        return view;
    }

    private boolean validateTelephone(String telephone){
        if(!Character.isDigit(telephone.charAt(0)) || telephone.charAt(0)!='+'){
            return false;
        }
        for(int index=1;index<telephone.length();index++){
            if(!Character.isDigit(telephone.charAt(index))){
                return false;
            }
        }
        return true;
    }

    private boolean validateEmail(String email){
        final String regex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }


}

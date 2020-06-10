package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

public class NewAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_new_account, container, false);
        Button btnCreateAccount=view.findViewById(R.id.btnCreateAccount);
        Button btnCancel=view.findViewById(R.id.btnCancel);

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
                TextInputEditText txtPassword=view.findViewById(R.id.txtPassword);
                TextInputEditText txtConformPassword=view.findViewById(R.id.txtConformPassword);
                if(!validateTelephone(txtTelephone.getText().toString())){
                    Toast toast=Toast.makeText(getContext(), R.string.invalid_telephone,Toast.LENGTH_LONG);
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


}

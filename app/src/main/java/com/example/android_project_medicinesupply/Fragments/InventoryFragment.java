package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;

public class InventoryFragment extends Fragment {

    private User user;
    private TextView txtName;

    public InventoryFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        txtName = view.findViewById(R.id.txtName);
        txtName.setText("User: " + user.getName());

        return view;
    }
}

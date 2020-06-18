package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.android_project_medicinesupply.Database.Medicine;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;

import java.util.List;


public class OrderFragment extends Fragment {

    private User user;
    private List<Medicine> medicines;

    public OrderFragment(User user, List<Medicine> medicines) {
        this.user = user;
        this.medicines = medicines;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}

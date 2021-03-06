package com.example.android_project_medicinesupply.Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_medicinesupply.Activities.ReportsActivity;
import com.example.android_project_medicinesupply.Database.InsertMedicineAsync;
import com.example.android_project_medicinesupply.Database.Medicine;
import com.example.android_project_medicinesupply.Database.MedicineAdapter;
import com.example.android_project_medicinesupply.Database.SelectAllMedicinesAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;
import com.example.android_project_medicinesupply.Utils.ClickListener;
import com.example.android_project_medicinesupply.Utils.TouchListener;
import com.example.android_project_medicinesupply.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class InventoryFragment extends Fragment {

    private User user;
    private TextView txtName;
    private List<Medicine> medicines;
    private MedicineAdapter medicineAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private List<Medicine> orderMedicine;
    private Button btnAddMedicine;
    private Button btnPlaceOrder;
    private Button btnDetails;

    public InventoryFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        btnAddMedicine = view.findViewById(R.id.btnAddMedicine);
        btnPlaceOrder = view.findViewById(R.id.btnPlaceOrder);
        btnDetails = view.findViewById(R.id.btnSeeDetails);
        txtName = view.findViewById(R.id.txtName);
        txtName.setText(getString(R.string.user) + " " + user.getName());
        recyclerView = view.findViewById(R.id.medicineRecyclerView);
        AsyncTask<Void, Void, List<Medicine>> asyncTask = new SelectAllMedicinesAsync().execute();

        try {
            medicines = asyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (medicines.size() == 0) {
            getMedicineFromJson();
        }

        populateRecyclerView();
        orderMedicine = new ArrayList<>();

        btnAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentFrame, new NewMedicineFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        recyclerView.addOnItemTouchListener(new TouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Medicine medicine = medicines.get(position);
                orderMedicine.add(medicine);
                Toast toast = Toast.makeText(getContext(), medicine.getName() + " " + getString(R.string.add_medicine_to_order), Toast.LENGTH_LONG);
                toast.show();
            }
        }));

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentFrame, new OrderFragment(user, orderMedicine));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReportsActivity.class);
                intent.putExtra("email", user.getEmail());
                intent.putExtra("password", user.getPassword());
                startActivity(intent);
            }
        });

        return view;
    }

    private void populateRecyclerView() {
        if (medicines.size() > 0) {
            Collections.sort(medicines, new Comparator<Medicine>() {
                @Override
                public int compare(final Medicine o1, final Medicine o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        medicineAdapter = new MedicineAdapter(medicines);
        recyclerView.setAdapter(medicineAdapter);

    }

    private void getMedicineFromJson() {
        String jsonString = Utils.getJsonFromAssets(getContext(), "products.json");
        Gson gson = new Gson();
        Type listMedicineType = new TypeToken<List<Medicine>>() {
        }.getType();
        medicines = gson.fromJson(jsonString, listMedicineType);

        for (Medicine medicine : medicines) {
            AsyncTask<Medicine, Void, Void> asyncTask = new InsertMedicineAsync().execute(medicine);
        }
    }

}

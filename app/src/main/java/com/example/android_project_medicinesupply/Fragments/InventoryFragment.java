package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_medicinesupply.Database.Medicine;
import com.example.android_project_medicinesupply.Database.MedicineAdapter;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;
import com.example.android_project_medicinesupply.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class InventoryFragment extends Fragment {

    private User user;
    private TextView txtName;
    private List<Medicine> medicines;
    private MedicineAdapter medicineAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;

    public InventoryFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        txtName = view.findViewById(R.id.txtName);
        txtName.setText("User: " + user.getName());
        recyclerView = view.findViewById(R.id.medicineRecyclerView);
        populateRecyclerView();
        return view;
    }

    private void populateRecyclerView() {
        String jsonString = Utils.getJsonFromAssets(getContext(), "products.json");
        Gson gson = new Gson();
        Type listMedicineType = new TypeToken<List<Medicine>>() { }.getType();
        medicines = gson.fromJson(jsonString, listMedicineType);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        medicineAdapter = new MedicineAdapter(medicines);
        recyclerView.setAdapter(medicineAdapter);
    }
}

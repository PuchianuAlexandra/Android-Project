package com.example.android_project_medicinesupply.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.android_project_medicinesupply.Database.InsertMedicineAsync;
import com.example.android_project_medicinesupply.Database.Medicine;
import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

public class NewMedicineFragment extends Fragment {

    private TextInputEditText txtName;
    private TextInputEditText txtManufacturer;
    private TextInputEditText txtPills;
    private TextInputEditText txtConcentration;
    private TextInputEditText txtPrice;
    private TextInputEditText txtQuantity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_new_medicine, container, false);
        Button btnAddMedicine = view.findViewById(R.id.btnAddMedicine);
        Button btnCancel = view.findViewById(R.id.btnCancel);

        btnAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName = view.findViewById(R.id.txtName);
                txtManufacturer = view.findViewById(R.id.txtManufacturer);
                txtPills = view.findViewById(R.id.txtPills);
                txtConcentration = view.findViewById(R.id.txtConcentration);
                txtPrice = view.findViewById(R.id.txtPrice);
                txtQuantity = view.findViewById(R.id.txtQuantity);

                if (txtName.getText().toString().equals("") || txtManufacturer.getText().toString().equals("") || txtPills.getText().toString().equals("")
                        || txtConcentration.getText().toString().equals("") || txtPrice.getText().toString().equals("") || txtQuantity.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getContext(), R.string.fill_all_boxes, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Medicine medicine = new Medicine(txtName.getText().toString(), txtManufacturer.getText().toString(),
                            Integer.parseInt(txtPills.getText().toString()), Integer.parseInt(txtConcentration.getText().toString()),
                            Integer.parseInt(txtQuantity.getText().toString()), Double.parseDouble(txtPrice.getText().toString()));
                    AsyncTask<Medicine, Void, Void> asyncTask = new InsertMedicineAsync().execute(medicine);
                    Toast toast = Toast.makeText(getContext(), R.string.medicine_added, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    getActivity().getSupportFragmentManager().popBackStackImmediate();
                }
            }
        });

        return view;
    }
}

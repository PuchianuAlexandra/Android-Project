package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_project_medicinesupply.R;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewMedicineFragment extends Fragment {

    public NewMedicineFragment() {
        // Required empty public constructor
    }


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
                TextInputEditText txtName = view.findViewById(R.id.txtName);
                TextInputEditText txtManufacturer = view.findViewById(R.id.txtManufacturer);
                TextInputEditText txtPills = view.findViewById(R.id.txtPills);
                TextInputEditText txtConcentration = view.findViewById(R.id.txtConcentration);
                TextInputEditText txtPrice = view.findViewById(R.id.txtPrice);
                TextInputEditText txtQuantity = view.findViewById(R.id.txtQuantity);

                if (txtName.getText().toString().equals("") || txtManufacturer.getText().toString().equals("") || txtPills.getText().toString().equals("")
                        || txtConcentration.getText().toString().equals("") || txtPrice.getText().toString().equals("") || txtQuantity.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getContext(), R.string.fill_all_boxes, Toast.LENGTH_LONG);
                    toast.show();
                } else {
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

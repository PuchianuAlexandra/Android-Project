package com.example.android_project_medicinesupply.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_medicinesupply.Database.InsertMedicineOrderAsync;
import com.example.android_project_medicinesupply.Database.InsertOrderAsync;
import com.example.android_project_medicinesupply.Database.Medicine;
import com.example.android_project_medicinesupply.Database.MedicineAdapter;
import com.example.android_project_medicinesupply.Database.MedicineOrder;
import com.example.android_project_medicinesupply.Database.Order;
import com.example.android_project_medicinesupply.Database.SelectMedicineAsync;
import com.example.android_project_medicinesupply.Database.UpdateQuantityAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;
import com.example.android_project_medicinesupply.Utils.ClickListener;
import com.example.android_project_medicinesupply.Utils.TouchListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class OrderFragment extends Fragment {

    private User user;
    private List<Medicine> medicines;
    private RecyclerView recyclerView;
    private MedicineAdapter medicineAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public OrderFragment(User user, List<Medicine> medicines) {
        this.user = user;
        this.medicines = medicines;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnOrder = view.findViewById(R.id.btnOrder);

        recyclerView = view.findViewById(R.id.orderRecyclerView);
        populateRecyclerView();

        recyclerView.addOnItemTouchListener(new TouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast toast = Toast.makeText(getContext(), medicines.get(position).getName().toString() + " " + getString(R.string.deleted), Toast.LENGTH_LONG);
                toast.show();

                medicines.remove(position);
                populateRecyclerView();
            }
        }));

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    getActivity().getSupportFragmentManager().popBackStackImmediate();
                }
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order(user.getId());
                AsyncTask<Order, Void, Integer> insertAsyncTask = new InsertOrderAsync().execute(order);

                try {
                    order.setId(insertAsyncTask.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(Medicine medicine : medicines) {
                    AsyncTask<Integer, Void, Medicine> asyncTask = new SelectMedicineAsync().execute(medicine.getId());

                    try {
                        medicine = asyncTask.get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    MedicineOrder medicineOrder = new MedicineOrder(order.getId(), medicine.getId());
                    new InsertMedicineOrderAsync().execute(medicineOrder);
                    new UpdateQuantityAsync().execute(medicine);
                }

                Toast toast = Toast.makeText(getContext(), getString(R.string.order_placed), Toast.LENGTH_LONG);
                toast.show();

                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    getActivity().getSupportFragmentManager().popBackStackImmediate();
                }
            }
        });

        return view;
    }

    private void populateRecyclerView() {
        if(medicines.size() > 0) {
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
}

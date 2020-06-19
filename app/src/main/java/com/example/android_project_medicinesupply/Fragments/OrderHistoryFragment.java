package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_medicinesupply.Database.Order;
import com.example.android_project_medicinesupply.Database.OrderAdapter;
import com.example.android_project_medicinesupply.Database.SelectOrdersAsync;
import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class OrderHistoryFragment extends Fragment {

    private User user;
    private List<Order> orders;
    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public OrderHistoryFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_history, container, false);
        recyclerView = view.findViewById(R.id.ordersRecyclerView);
        Button btnCancel = view.findViewById(R.id.btnCancel);

        try {
            populateRecyclerView();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

    private void populateRecyclerView() throws ExecutionException, InterruptedException {
        orders = new SelectOrdersAsync().execute().get();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        orderAdapter = new OrderAdapter(orders, getActivity());
        recyclerView.setAdapter(orderAdapter);
    }
}

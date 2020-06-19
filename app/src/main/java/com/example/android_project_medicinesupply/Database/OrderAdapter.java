package com.example.android_project_medicinesupply.Database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_medicinesupply.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<Order> orders;
    private Context context;

    public OrderAdapter(List<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);

        try {
            User user = new SelectUserByIdAsync().execute(order.getUserId()).get();
            holder.txtUser.setText("User: " + user.getName());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Medicine> medicines = new ArrayList<>();
        List<MedicineOrder> medicineOrderList = new ArrayList<>();

        try {
            medicineOrderList = new SelectMedicineOrderAsync().execute(order.getId()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(MedicineOrder medicineOrder : medicineOrderList) {
            Medicine medicine = new Medicine();

            try {
                medicine = new SelectMedicineAsync().execute(medicineOrder.getIdMedicine()).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            medicines.add(medicine);
        }

        MedicineAdapter medicineAdapter;
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(layoutManager);
        medicineAdapter = new MedicineAdapter(medicines);
        holder.recyclerView.setAdapter(medicineAdapter);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUser = itemView.findViewById(R.id.txtUser);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}

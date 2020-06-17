package com.example.android_project_medicinesupply.Database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_medicinesupply.R;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    private List<Medicine> medicines;

    public MedicineAdapter(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtProductName.setText(medicines.get(position).getName());
        holder.txtManufacturer.setText(medicines.get(position).getManufacturer());
        holder.txtPills.setText(medicines.get(position).getNoPills());
        holder.txtConcentration.setText(medicines.get(position).getConcentration());
        holder.txtPrice.setText(medicines.get(position).getConcentration());
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductName;
        TextView txtManufacturer;
        TextView txtPills;
        TextView txtConcentration;
        TextView txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtManufacturer = itemView.findViewById(R.id.txtManufacturer);
            txtPills = itemView.findViewById(R.id.txtPills);
            txtConcentration = itemView.findViewById(R.id.txtConcentration);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}

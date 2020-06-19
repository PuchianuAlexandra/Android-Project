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
        int quantity = medicines.get(position).getQuantity();
        int noPills = medicines.get(position).getNoPills();
        int concentration = medicines.get(position).getConcentration();
        double price = medicines.get(position).getPrice();

        holder.txtProductName.setText(medicines.get(position).getName());
        holder.txtQuantity.setText("| Quantity: " + Integer.toString(quantity));
        holder.txtManufacturer.setText("Manufacturer: " + medicines.get(position).getManufacturer());
        holder.txtPills.setText(Integer.toString(noPills) + " pills x ");
        holder.txtConcentration.setText(Integer.toString(concentration) + " mg   ");
        holder.txtPrice.setText(Double.toString(price) + " lei");
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductName;
        TextView txtQuantity;
        TextView txtManufacturer;
        TextView txtPills;
        TextView txtConcentration;
        TextView txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            txtManufacturer = itemView.findViewById(R.id.txtManufacturer);
            txtPills = itemView.findViewById(R.id.txtPills);
            txtConcentration = itemView.findViewById(R.id.txtConcentration);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}

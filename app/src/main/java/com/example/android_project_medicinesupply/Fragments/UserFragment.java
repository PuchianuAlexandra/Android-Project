package com.example.android_project_medicinesupply.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_project_medicinesupply.Database.User;
import com.example.android_project_medicinesupply.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private User user;

    public UserFragment(User user) {
        this.user = user;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        TextView txtUserName = view.findViewById(R.id.txtUserName);
        TextView txtTelephone = view.findViewById(R.id.txtTelephone);
        TextView txtEmail = view.findViewById(R.id.txtEmail);
        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnOrderHistory = view.findViewById(R.id.btnOrderHistory);

        txtUserName.setText(user.getName());
        txtTelephone.setText("Telephone: " + user.getTelephone());
        txtEmail.setText("Email: " + user.getEmail());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        btnOrderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragmentFrame, new OrderHistoryFragment(user));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}

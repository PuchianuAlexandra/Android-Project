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
    private TextView txtUserName;
    private TextView txtTelephone;
    private TextView txtEmail;
    private Button btnCancel;
    private Button btnOrderHistory;

    public UserFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        txtUserName = view.findViewById(R.id.txtUserName);
        txtTelephone = view.findViewById(R.id.txtTelephone);
        txtEmail = view.findViewById(R.id.txtEmail);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnOrderHistory = view.findViewById(R.id.btnOrderHistory);
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

package com.example.androidfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidfragment.R;
import com.example.androidfragment.data.Pizza;

/**
 * Created by aruna on 12/2/17.
 */

public class PizzaDetailFragment extends Fragment {
    int position = 0;
    TextView tvTitle;
    TextView tvDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            if (getArguments() != null) {
                position = getArguments().getInt("position",0);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pizza_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Set values for view here
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvDetails = (TextView) view.findViewById(R.id.tvDetails);

        // update view
        tvTitle.setText(Pizza.pizzaMenu[position]);
        tvDetails.setText(Pizza.pizzaDetails[position]);
    }

    // Activity is calling this to update view on Fragment
    public void updateView(int position){
        tvTitle.setText(Pizza.pizzaMenu[position]);
        tvDetails.setText(Pizza.pizzaDetails[position]);
    }
}

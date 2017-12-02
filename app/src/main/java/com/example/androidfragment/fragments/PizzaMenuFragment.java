package com.example.androidfragment.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androidfragment.R;
import com.example.androidfragment.data.Pizza;

/**
 * Created by aruna on 12/2/17.
 */

public class PizzaMenuFragment extends Fragment {
    ArrayAdapter<String> itemsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Pizza.pizzaMenu);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pizza_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(itemsAdapter);

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // go to activity to load pizza details fragment
                listener.onPizzaItemSelected(position); // (3) Communicate with Activity using Listener
            }
        });
    }

    private OnItemSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnItemSelectedListener){      // context instanceof YourActivity
            this.listener = (OnItemSelectedListener) context; // = (YourActivity) context
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement PizzaMenuFragment.OnItemSelectedListener");
        }
    }

    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        void onPizzaItemSelected(int position);
    }
}

package com.example.khlopunov.cityweather.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.khlopunov.cityweather.R;
import com.example.khlopunov.cityweather.entities.City;
import com.example.khlopunov.cityweather.providers.CitiesProvider;

/**
 * Created by Admin on 09.11.2016.
 */

public class AddCityFragment extends DialogFragment {
   private EditText etCityName;
   private Button btnAdd;
   private Button btnClose;
    private MyFragment myFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Add City");
        View view = inflater.inflate(R.layout.my_dialog, null);
        etCityName = (EditText) view.findViewById(R.id.et_name_city);
        btnAdd = (Button) view.findViewById(R.id.btn_add);
        btnClose = (Button) view.findViewById(R.id.btn_close);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etCityName.getText().toString();

                etCityName.setText("");
//                myFragment = ;

                if(new MyFragment().newInstance(name).getResult()) {
                    CitiesProvider.getInstance(getActivity()).addCity(new City(
                            name));
                }

                dismiss();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
}

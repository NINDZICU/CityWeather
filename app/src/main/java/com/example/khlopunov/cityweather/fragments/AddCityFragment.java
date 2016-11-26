package com.example.khlopunov.cityweather.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.khlopunov.cityweather.R;
import com.example.khlopunov.cityweather.entities.City;
import com.example.khlopunov.cityweather.providers.CitiesProvider;
import com.example.khlopunov.cityweather.interfaces.TaskInterface;


/**
 * Created by Admin on 09.11.2016.
 */

public class AddCityFragment extends DialogFragment implements TaskInterface {
    private EditText etCityName;
    private Button btnAdd;
    private Button btnClose;
    private ProgressBar progressBar;
    private MyFragment myFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Add City");
        View view = inflater.inflate(R.layout.my_dialog, null);
        etCityName = (EditText) view.findViewById(R.id.et_name_city);
        btnAdd = (Button) view.findViewById(R.id.btn_add);
        btnClose = (Button) view.findViewById(R.id.btn_close);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etCityName.getText().toString();

                etCityName.setText("");
                myFragment = new MyFragment().newInstance(name);
                myFragment.startTask(name);

                while (!myFragment.isContin()) {
                }
                if (myFragment.getResult()) {
                    CitiesProvider.getInstance(getActivity()).addCity(new City(
                            name));
                }
                dismiss();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFragment.stopTask();
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onTaskStart() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onUpgrade(int i) {

    }

    @Override
    public void onFinish(String s) {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onTaskCancel() {
        progressBar.setVisibility(View.GONE);
    }
}

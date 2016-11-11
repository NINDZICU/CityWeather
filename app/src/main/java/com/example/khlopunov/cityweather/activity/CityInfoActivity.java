package com.example.khlopunov.cityweather.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.khlopunov.cityweather.R;
import com.example.khlopunov.cityweather.asyncTasks.RetrofitAsyncTask;

public class CityInfoActivity extends AppCompatActivity {

    private TextView tvNameCity;
    public TextView tvDegrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_info);

        tvNameCity = (TextView) findViewById(R.id.tv_name_city);
        tvDegrees = (TextView) findViewById(R.id.tv_degrees);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        RetrofitAsyncTask retrofitAsyncTask = new RetrofitAsyncTask(CityInfoActivity.this, name);
        retrofitAsyncTask.execute();
//        String degrees = intent.getStringExtra("degrees");
        tvNameCity.setText(name);
//        tvDegrees.setText(degrees);

    }
}

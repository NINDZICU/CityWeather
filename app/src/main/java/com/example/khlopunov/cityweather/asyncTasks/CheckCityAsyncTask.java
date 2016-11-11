package com.example.khlopunov.cityweather.asyncTasks;

import android.os.AsyncTask;

import com.example.khlopunov.cityweather.activity.MainActivity;
import com.example.khlopunov.cityweather.entities.City;
import com.example.khlopunov.cityweather.interfaces.OpenWeatherMap;
import com.example.khlopunov.cityweather.pojo.Weather;
import com.example.khlopunov.cityweather.providers.CitiesProvider;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 11.11.2016.
 */

public class CheckCityAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private MainActivity mainActivity;
    private String name;

    public CheckCityAsyncTask(MainActivity mainActivity, String name) {
        this.mainActivity = mainActivity;
        this.name = name;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org").addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMap openWeatherMap = retrofit.create(OpenWeatherMap.class);

        Call<Weather> weatherCall = openWeatherMap.getWeather(name, OpenWeatherMap.API_KEY);
        try {
            Response<Weather> response = weatherCall.execute();
            if (response.errorBody().equals("502")) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(!aBoolean){
            mainActivity.tvError.setText("Название города введено некорректно");
        }
        else{
            CitiesProvider.getInstance(mainActivity).addCity( new City(
                    name));

        }
    }
}

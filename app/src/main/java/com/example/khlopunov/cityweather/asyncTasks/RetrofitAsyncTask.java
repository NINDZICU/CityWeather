package com.example.khlopunov.cityweather.asyncTasks;

import android.os.AsyncTask;

import com.example.khlopunov.cityweather.interfaces.OpenWeatherMap;
import com.example.khlopunov.cityweather.activity.CityInfoActivity;
import com.example.khlopunov.cityweather.interfaces.TaskInterface;
import com.example.khlopunov.cityweather.pojo.Weather;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 10.11.2016.
 */

//public class RetrofitAsyncTask extends AsyncTask<Void, Integer, String> {
//
//    private TaskInterface taskInterface;
//    private CityInfoActivity cityInfoActivity;
//    private String name;
//
//    public RetrofitAsyncTask(CityInfoActivity cityInfoActivity, String name) {
//        this.cityInfoActivity = cityInfoActivity;
//        this.name = name;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        if (taskInterface != null) {
//            taskInterface.onTaskStart();
//        }
//    }
//
//    @Override
//    protected String doInBackground(Void... params) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://api.openweathermap.org").addConverterFactory(GsonConverterFactory.create())
//                .build();
//        try {
//            int randomProgress = 0;
//            // Simulate some heavy work.
//            while (randomProgress < 100 && !isCancelled()) {
//                randomProgress += 5;
//                publishProgress(randomProgress);
//                Thread.sleep(200);
//            }
//        } catch (InterruptedException e) {
//            return null;
//        }
//
//        OpenWeatherMap openWeatherMap = retrofit.create(OpenWeatherMap.class);
//
//        Call<Weather> weatherCall = openWeatherMap.getWeather(name, OpenWeatherMap.API_KEY);
//        String temp = "";
//        try {
//            Response<Weather> response = weatherCall.execute();
//            if (response.errorBody() != null) {                                //обработка ошибки
//                return String.valueOf(response.code());
//            }
//            Weather weather = response.body();
//            temp = (String.valueOf((int) (weather.getMain().getTemp() - 273)) + " °С");
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return temp;
//    }
//
//
//
//    @Override
//    protected void onPostExecute(String s) {
//        cityInfoActivity.tvDegrees.setText(s);
//    }
//
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        if(taskInterface!=null) {
//            taskInterface.onUpgrade(values[0]);
//        }
//    }
//
//    @Override
//    protected void onCancelled() {
//        task=null;
//        if(taskInterface!=null){
//            taskInterface.onTaskCancel();
//        }
//    }
//}

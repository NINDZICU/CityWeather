package com.example.khlopunov.cityweather.interfaces;

import com.example.khlopunov.cityweather.pojo.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 10.11.2016.
 */

public interface OpenWeatherMap {
    String API_KEY ="1d3d1ee8dd65190c320269c3713e4ecc";

    @GET("data/2.5/weather")
    Call<Weather> getWeather(@Query("q") String city, @Query("appid") String id);
}


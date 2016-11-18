package com.example.khlopunov.cityweather.interfaces;

/**
 * Created by Admin on 18.11.2016.
 */

public interface TaskInterface {
    void onTaskStart();
    void onUpgrade(int i);
    void onFinish(String s);
    void onTaskCancel();
}

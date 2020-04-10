package com.example.recyclerview.network

import com.example.recyclerview.AppConstants

object ApiFactory{

    val weatherHolderApi: WeatherApi = RetrofitFactory.retrofit(AppConstants.WEATHER_BASE_URL)
        .create(WeatherApi::class.java)
}
package com.example.recyclerview.network

import com.example.recyclerview.WEATHER_BASE_URL

object ApiFactory{

    val weatherHolderApi: WeatherApi = RetrofitFactory.retrofit(WEATHER_BASE_URL)
        .create(WeatherApi::class.java)
}
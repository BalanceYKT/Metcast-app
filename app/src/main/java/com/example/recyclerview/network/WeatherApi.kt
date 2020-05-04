package com.example.recyclerview.network

import com.example.recyclerview.model.Forecast
import com.example.recyclerview.model.Metcast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    fun getWeather(@Query("q") cityName: String, @Query("units") TemperatureUnit: String): Call<List<Metcast>>
}
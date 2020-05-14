package com.example.recyclerview.network

import com.example.recyclerview.model.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(@Query("q") cityName: String, @Query("units") TemperatureUnit: String): Forecast
}
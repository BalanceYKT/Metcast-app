package com.example.recyclerview.Train

import retrofit2.Call
import retrofit2.http.GET

interface ApiService{

    @GET("/users")
    fun fetchAllUsers(): Call<List<User>>
}
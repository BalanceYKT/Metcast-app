package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Train.ApiService
import com.example.recyclerview.Train.User
import com.example.recyclerview.Train.myAdapter
import com.example.recyclerview.model.Forecast
import com.example.recyclerview.model.Metcast
import com.example.recyclerview.network.ApiFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // --------------------------------------
/*        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

 */

        // -------------------network service ---------------------



        val weatherService = ApiFactory.weatherHolderApi
        weatherService.getWeather(YakutskCity, TemperatureUnit).enqueue(object : Callback<List<Metcast>>{
            override fun onResponse(
                call: Call<List<Metcast>>,
                response: Response<List<Metcast>>
            ) {
                showData(response.body()!!)
                d("asd", "Success" )
            }

            override fun onFailure(call: Call<List<Metcast>>, t: Throwable) {
                d("asd","Fail")
            }
        })


    }

    private fun showData(Items: List<Metcast>) {
        recycler_view.apply {
            adapter = Adapter(Items)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }



}

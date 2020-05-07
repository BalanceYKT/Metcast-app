package com.example.recyclerview

import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.TabHost
import android.widget.TabHost.TabSpec
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.model.Forecast
import com.example.recyclerview.network.ApiFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // инициализация
        // инициализация
        tabHostT.setup()

        // создаем вкладку и указываем тег

        // создаем вкладку и указываем тег
        val tabSpec = tabHostT.newTabSpec("tag1")
        tabSpec.setIndicator("Today")
        tabSpec.setContent(my_recycler_view.id)
        tabHostT.addTab(tabSpec)

        val tabSpec2 = tabHostT.newTabSpec("tag2")
        tabSpec2.setIndicator("Tomorrow")
        tabSpec2.setContent(my_recycler_view2.id)
        tabHostT.addTab(tabSpec2)

        val tabSpec3 = tabHostT.newTabSpec("tag2")
        tabSpec3.setIndicator("On week")
        tabSpec3.setContent(my_recycler_view3.id)
        tabHostT.addTab(tabSpec3)



        // -------------------network service ---------------------
        val weatherService = ApiFactory.weatherHolderApi
        weatherService.getWeather(YakutskCity, TemperatureUnit).enqueue(object : Callback<Forecast>{
            override fun onResponse(call: Call<Forecast>, response: Response<Forecast>) {
                showData(response.body()!!)
                d("asd", "Success" )
            }

            override fun onFailure(call: Call<Forecast>, t: Throwable) {
                d("asd","Fail")
            }
        })


    }

    private fun showData(Items: Forecast) {
        my_recycler_view.apply {
            adapter = Adapter(Items)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        my_recycler_view2.apply {
            adapter = Adapter(Items)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        my_recycler_view3.apply {
            adapter = Adapter(Items)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }



}

package com.example.recyclerview

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.recyclerview.Adapters.Adapter
import com.example.recyclerview.Adapters.PagerAdapter
import com.example.recyclerview.model.Forecast
import com.example.recyclerview.network.ApiFactory
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        viewpager.adapter = fragmentAdapter

        tab_layout.setupWithViewPager(viewpager)

        // ------------------- TabHost -------------------
        tabHostT.setup()

        val tabSpec = tabHostT.newTabSpec("tag1")
        tabSpec.setIndicator("On Week")
        tabSpec.setContent(week.id)
        tabHostT.addTab(tabSpec)

        val tabSpec2 = tabHostT.newTabSpec("tag2")
        tabSpec2.setIndicator("On Next Week")
        tabSpec2.setContent(week2.id)
        tabHostT.addTab(tabSpec2)




        // ------------------- network service ---------------------
        val weatherService = ApiFactory.weatherHolderApi
        weatherService.getWeather(YakutskCity, TemperatureUnit).enqueue(object : Callback<Forecast>{
            override fun onResponse(call: Call<Forecast>, response: Response<Forecast>) {
                showData(response.body()!!)
                showRecyclerData(response.body()!!)
                d("asd", "Success" )
            }

            override fun onFailure(call: Call<Forecast>, t: Throwable) {
                d("asd","Fail")
            }
        })


    }


    private fun showData(Item: Forecast) {
        todayTemperature.text = Item.list[0].main.temp.toString()
        todayDescription.text = Item.list[0].weather[0].description
        todayWind.text = Item.list[0].wind.speed.toString()
        todayPressure.text = Item.list[0].main.pressure.toString()
        todayHumidity.text = Item.list[0].main.humidity.toString()
        todayImageViewWeather.setImageResource(R.drawable.ic_weather_sun)
        val todayIcon = Item.list[0].weather[0].icon
        showIcon(todayIcon)
    }

    private fun showRecyclerData(Items: Forecast) {
        my_recycler_view1.apply {
            adapter = Adapter(Items)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        my_recycler_view2.apply {
            adapter = Adapter(Items)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    private fun showIcon(Icon: String) {
        when (Icon){
            "01d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_clear_sky)
                details.setBackgroundResource(R.color.color_clear_and_sunny)
            }
            "01n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_clear_sky)
                details.setBackgroundResource(R.color.color_clear_and_sunny)
            }
            "02d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_few_cloud)
                details.setBackgroundResource(R.color.color_partly_cloudy)
            }
            "02n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_few_cloud)
                details.setBackgroundResource(R.color.color_partly_cloudy)
            }
            "03d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_scattered_clouds)
                details.setBackgroundResource(R.color.color_gusty_winds)
            }
            "03n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_scattered_clouds)
                details.setBackgroundResource(R.color.color_gusty_winds)
            }
            "04d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_broken_clouds)
                details.setBackgroundResource(R.color.color_cloudy_overnight)
            }
            "04n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_broken_clouds)
                details.setBackgroundResource(R.color.color_cloudy_overnight)
            }
            "09d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_shower_rain)
                details.setBackgroundResource(R.color.color_hail_stroms)
            }
            "09n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_shower_rain)
                details.setBackgroundResource(R.color.color_hail_stroms)
            }
            "10d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_rain)
                details.setBackgroundResource(R.color.color_heavy_rain)
            }
            "10n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_rain)
                details.setBackgroundResource(R.color.color_heavy_rain)
            }
            "11n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_thunderstorm)
                details.setBackgroundResource(R.color.color_thunderstroms)
            }
            "11d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_thunderstorm)
                details.setBackgroundResource(R.color.color_thunderstroms)
            }
            "13d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_snow)
                details.setBackgroundResource(R.color.color_snow)
            }
            "13n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_snow)
                details.setBackgroundResource(R.color.color_snow)
            }
            "15d" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_mist)
                details.setBackgroundResource(R.color.color_mix_snow_and_rain)
            }
            "15n" -> {
                todayImageViewWeather.setImageResource(R.drawable.ic_weather_mist)
                details.setBackgroundResource(R.color.color_mix_snow_and_rain)
            }
        }
    }


}

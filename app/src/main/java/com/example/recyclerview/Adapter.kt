package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.model.Forecast
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private val ItemList: Forecast) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,
            parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = ItemList.cnt

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = ItemList.list[position]
        holder.textView1.text = currentItem.main.temp.toString()
        holder.textView2.text = currentItem.main.feels_like.toString()
        holder.textView3.text = currentItem.dt_txt
        bindIcon(currentItem.weather[0].icon, holder.imageViev)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageViev: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
        val textView3: TextView = itemView.textView
    }

    private fun bindIcon(Icon: String, image: ImageView) {
        when (Icon) {
            "01d" -> image.setImageResource(R.drawable.ic_weather_clear_sky)
            "01n" -> image.setImageResource(R.drawable.ic_weather_clear_sky)
            "02d" -> image.setImageResource(R.drawable.ic_weather_few_cloud)
            "02n" -> image.setImageResource(R.drawable.ic_weather_few_cloud)
            "03d" -> image.setImageResource(R.drawable.ic_weather_scattered_clouds)
            "03n" -> image.setImageResource(R.drawable.ic_weather_scattered_clouds)
            "04d" -> image.setImageResource(R.drawable.ic_weather_broken_clouds)
            "04n" -> image.setImageResource(R.drawable.ic_weather_broken_clouds)
            "09d" -> image.setImageResource(R.drawable.ic_weather_shower_rain)
            "09n" -> image.setImageResource(R.drawable.ic_weather_shower_rain)
            "10d" -> image.setImageResource(R.drawable.ic_weather_rain)
            "10n" -> image.setImageResource(R.drawable.ic_weather_rain)
            "11n" -> image.setImageResource(R.drawable.ic_weather_thunderstorm)
            "11d" -> image.setImageResource(R.drawable.ic_weather_thunderstorm)
            "13d" -> image.setImageResource(R.drawable.ic_weather_snow)
            "13n" -> image.setImageResource(R.drawable.ic_weather_snow)
            "15d" -> image.setImageResource(R.drawable.ic_weather_mist)
            "15n" -> image.setImageResource(R.drawable.ic_weather_mist)
        }
    }


}
package com.example.recyclerview

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.model.Forecast
import com.example.recyclerview.model.Metcast
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private val ItemList: List<Metcast>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,
            parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = ItemList[position]
        holder.imageViev.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.cod
        holder.textView2.text = currentItem.temp as? String
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageViev: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}
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
        holder.textView1.text = ItemList.cod
        holder.textView2.text = currentItem.dt.toString()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageViev: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}
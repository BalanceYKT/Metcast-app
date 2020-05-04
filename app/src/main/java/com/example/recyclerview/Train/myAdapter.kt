package com.example.recyclerview.Train

import com.example.recyclerview.R

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class myAdapter(private val ItemList: List<User>) : RecyclerView.Adapter<myAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = ItemList[position]
        holder.textView1.text = currentItem.phone
        holder.textView2.text = currentItem.secondName
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}
package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myList = generateDummyList(500)
        recycler_view.adapter = Adapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<Item>{
        val list = ArrayList<Item>()

        for (i in 0 until size){
            val drawable = when (i%3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }

            val item = Item(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}

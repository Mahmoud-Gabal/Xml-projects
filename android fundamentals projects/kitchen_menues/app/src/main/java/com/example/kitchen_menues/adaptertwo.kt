package com.example.kitchen_menues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class adaptertwo (var dataList: List<DataClass>)
    :RecyclerView.Adapter<ViewHolder>(){

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_second,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.apply {
        var image2 = findViewById<ImageView>(R.id.image2)
        var desc2 = findViewById<TextView>(R.id.desc2)
        image2.setImageResource(dataList[position].imagesrc)
        desc2.text = dataList[position].txt
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}
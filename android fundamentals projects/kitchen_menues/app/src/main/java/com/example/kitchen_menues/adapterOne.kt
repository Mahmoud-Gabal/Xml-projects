package com.example.kitchen_menues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterOne(var dataList : List<DataClass>)
    :RecyclerView.Adapter<adapterOne.ViewHolder>(){
        inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_first,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            var image1 = findViewById<ImageView>(R.id.image1)
            var desc1 = findViewById<TextView>(R.id.desc1)
            image1.setImageResource(dataList[position].imagesrc)
            desc1.text = dataList[position].txt
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
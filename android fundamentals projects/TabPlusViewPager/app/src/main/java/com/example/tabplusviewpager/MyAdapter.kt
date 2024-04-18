package com.example.tabplusviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var dataList : List<Int>)
    :RecyclerView.Adapter<MyAdapter.ViewHolder>(){
        inner class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var View = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item,parent,false)
       return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            var imgItem = findViewById<ImageView>(R.id.imageViewItem)
            imgItem.setImageResource(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
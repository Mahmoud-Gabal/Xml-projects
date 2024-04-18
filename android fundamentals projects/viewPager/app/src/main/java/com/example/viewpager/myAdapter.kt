package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class myAdapter(var dataList: List<recycleDataClass>)
    :RecyclerView.Adapter<myAdapter.ViewHolder>(){
        inner class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemView.apply {
           var imgItemOfRecycleItem = findViewById<ImageView>(R.id.imageView_of_recycleItem)
           var textViewOfRecycleItem = findViewById<TextView>(R.id.textView_of_recycleItem)
           imgItemOfRecycleItem.setImageResource(dataList[position].img)
           textViewOfRecycleItem.text = dataList[position].txt
       }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
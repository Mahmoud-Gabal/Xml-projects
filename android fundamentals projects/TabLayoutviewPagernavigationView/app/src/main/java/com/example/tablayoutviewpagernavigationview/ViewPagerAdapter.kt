package com.example.tablayoutviewpagernavigationview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(var dataList: List<Int>)
    :RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>(){
        inner class ViewHolder(ItemView:View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            var imgItem = findViewById<ImageView>(R.id.imageViewPAgerItemID)
            imgItem.setImageResource(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class adapterForViewPager(var imgList: List<Int>)
    :RecyclerView.Adapter<adapterForViewPager.ViewHolder>(){

        inner class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            var imgViewForViewPagerItem = findViewById<ImageView>(R.id.imageView_of_viewpagerItem)
            imgViewForViewPagerItem.setImageResource(imgList[position])
        }
    }

    override fun getItemCount(): Int {
        return imgList.size
    }
}
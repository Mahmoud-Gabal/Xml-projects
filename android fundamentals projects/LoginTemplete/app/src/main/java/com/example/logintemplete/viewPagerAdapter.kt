package com.example.logintemplete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class viewPagerAdapter(var datalist : List<Int>)
    :RecyclerView.Adapter<viewPagerAdapter.ViewHolder>(){
        inner class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            var imgitem = findViewById<ImageView>(R.id.imgItemForViewPager)
            imgitem.setImageResource(datalist[position])
        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}
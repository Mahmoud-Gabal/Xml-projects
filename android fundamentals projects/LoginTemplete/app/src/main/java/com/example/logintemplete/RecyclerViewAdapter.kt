package com.example.logintemplete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class RecyclerViewAdapter(var datalist : List<viewPagerAdapter>)
    :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
        inner class ViewHolder(ItemView : View) :RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            var vpitem = findViewById<ViewPager2>(R.id.ViewPagerItemid)
            vpitem.adapter = datalist[position]
        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}
package com.example.demoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoes.databinding.ListItemBinding
import com.google.android.material.imageview.ShapeableImageView


class MyAdapter (var doglist : List<Dog>)
    :RecyclerView.Adapter<MyAdapter.viewHolder>(){
    inner class viewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.apply {
            var myimage = findViewById<ShapeableImageView>(R.id.img1)
            var mytext = findViewById<TextView>(R.id.lorem1)
            mytext.text = doglist[position].desc
            myimage.setImageResource(doglist[position].image)
        }

    }

    override fun getItemCount(): Int {
        return doglist.size
    }
}
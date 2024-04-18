package com.example.todofirebaseapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofirebaseapp.R
import com.example.todofirebaseapp.dataclasses.todoDataClass

class recycleAdapter(val mylist : MutableList<todoDataClass>)
    :RecyclerView.Adapter<recycleAdapter.ViewHolder>(){
        inner class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView)
    private  var listener : AdapterButtonsListener ?=null
    fun setListener(listener: AdapterButtonsListener){
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val taskName = findViewById<TextView>(R.id.taskName)
            val btnEdit = findViewById<ImageView>(R.id.btnEdit)
            val btnDelete = findViewById<ImageView>(R.id.btnDelete)
            taskName.text = mylist[position].task
            btnEdit.setOnClickListener {
                listener?.OnBtnEditListener(mylist[position])
            }
            btnDelete.setOnClickListener {
                listener?.OnBtnDeleteListener(mylist[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return mylist.size
    }
    interface AdapterButtonsListener {
        fun OnBtnEditListener(todoDataClass: todoDataClass)
        fun OnBtnDeleteListener(todoDataClass: todoDataClass)
    }
}
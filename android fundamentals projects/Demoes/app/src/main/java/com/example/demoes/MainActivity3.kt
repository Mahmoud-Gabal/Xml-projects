package com.example.demoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoes.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        ------------------------------------------------------------------
        var commentList  = mutableListOf<CommentData>(

        )
        var adapter = Adapter_comment(commentList)
        binding.RecycleComment.adapter = adapter
        binding.RecycleComment.layoutManager = LinearLayoutManager(this)
        binding.btnAddComment.setOnClickListener {
            var new_comment = binding.editComment.text.toString()
            var data_comment = CommentData(new_comment)
            commentList.add(data_comment)
            adapter.notifyItemInserted(commentList.size - 1)
        }
    }
}
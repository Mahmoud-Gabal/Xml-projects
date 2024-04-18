package com.example.demoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoes.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var list_of_dogs = listOf<Dog>(
            Dog(R.drawable.a,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.b,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.c,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.d,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.e,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.f,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.g,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.h,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.i,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.j,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.a,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.b,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.c,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.d,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.e,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.f,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.g,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.h,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.i,"This is the description of this photo.it is a kind of animals which is cute."),
            Dog(R.drawable.j,"This is the description of this photo.it is a kind of animals which is cute."),
            )
        var adapter = MyAdapter(list_of_dogs)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.btnContinue2.setOnClickListener {
            Intent(this,MainActivity3::class.java).also {
                startActivity(it)
            }
        }
    }
}
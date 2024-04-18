package com.example.mykitchen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.mykitchen.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        ---------------------------------------------------------------
        binding.btnsign.setOnClickListener {
            var name = binding.edituser.text.toString()
            var pass = binding.editpass.text.toString()
            Intent(this,MainActivity2::class.java).also {
                it.putExtra("EXTRA_NAME",name)
                startActivity(it)
            }
        }
    }
}
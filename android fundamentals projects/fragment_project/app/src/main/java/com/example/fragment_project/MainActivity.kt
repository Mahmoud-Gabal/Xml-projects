package com.example.fragment_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    binding.btnfragment1.setOnClickListener {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Framelayout, FirstFragment())
            addToBackStack(null)
            commit()
        }
    }
    binding.btnfragment2.setOnClickListener {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Framelayout,SecondFragment())
            addToBackStack(null)
            commit()
        }
    }
    }
}
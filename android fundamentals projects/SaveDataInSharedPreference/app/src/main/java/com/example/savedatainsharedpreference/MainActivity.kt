package com.example.savedatainsharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savedatainsharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        -----------------------------------------------------------
        var sharePref = getSharedPreferences("MyPref", MODE_PRIVATE)
        var editor = sharePref.edit()
        binding.btnSave.setOnClickListener {
            var name = binding.edName.text.toString()
            var age = binding.edAge.text.toString().toInt()
            var isAdult = binding.chIsAdult.isChecked
            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply()
            }
        }
        binding.btnLoad.setOnClickListener {
            var name = sharePref.getString("name",null)
            var age = sharePref.getInt("age",0)
            var isAdult = sharePref.getBoolean("isAdult",false)
            binding.edName.setText(name)
            binding.edAge.setText(age.toString())
            binding.chIsAdult.isChecked = isAdult
        }
    }
}
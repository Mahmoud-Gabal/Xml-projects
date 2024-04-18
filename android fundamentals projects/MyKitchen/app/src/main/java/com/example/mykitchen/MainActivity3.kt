

package com.example.mykitchen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mykitchen.databinding.ActivityMain3Binding
import java.util.*

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding : ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        ----------------------------------------------------------
        var name = intent.getStringExtra("EXTRA_NAME")
        binding.textready.text = "Your order will be ready in \n 15 min,\nmr $name"
        binding.btnback.setOnClickListener {
            finish()
        }
        val imageview = findViewById<ImageView>(R.id.ivphoto)
        val button_upload = findViewById<Button>(R.id.btnupload)
        val gallery_launcher = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                imageview.setImageURI(it)
            })
        button_upload.setOnClickListener {
            gallery_launcher.launch("image/*")
        }
    }

}
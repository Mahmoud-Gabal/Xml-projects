package com.example.intentserviceservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.intentserviceservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btn_start_intent = findViewById<Button>(R.id.btnStartIntentService)
        val btn_stop_intent  = findViewById<Button>(R.id.btnStopIntentService)
        val txt_intent = findViewById<TextView>(R.id.txtIntentService)
        btn_start_intent.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                startService(it)
                txt_intent.text = "Intent Service is running"
            }
        }
        btn_stop_intent.setOnClickListener {
            MyIntentService.stopIntentService()
            txt_intent.text = "Intent Service stopped"
        }
        val btn_start_service = findViewById<Button>(R.id.btnStartService)
        val btn_stop_service = findViewById<Button>(R.id.btnStopService)
        val txt_service = findViewById<TextView>(R.id.txtService)
        btn_start_service.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                txt_service.text = "Service is running"
            }
        }
        btn_stop_service.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                txt_service.text = "Service is stopped"
            }
        }
        binding.btnsend.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val name = binding.edName.text.toString()
                it.putExtra("EXTRA_NAME",name)
                startService(it)
            }
        }
    }
}
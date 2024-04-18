package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_start = findViewById<Button>(R.id.btnStartService)
        val button_stop = findViewById<Button>(R.id.btnStopService)
        val text_service = findViewById<TextView>(R.id.txtService)
        button_start.setOnClickListener {
            Intent(this,IntentService::class.java).also {
                startService(it)
                text_service.text = "Service is running"
            }
        }
        button_stop.setOnClickListener {
            IntentService.stopIntentService()
            text_service.text = "Service is stopped"
        }
    }
}
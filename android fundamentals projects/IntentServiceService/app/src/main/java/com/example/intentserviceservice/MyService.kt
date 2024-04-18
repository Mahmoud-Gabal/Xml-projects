package com.example.intentserviceservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    init {
        Log.d("Service","Service is running")
    }
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data_string = intent?.getStringExtra("EXTRA_NAME")
        data_string?.let {
            Log.d("Service",data_string)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service","Service is stopped")
    }
}
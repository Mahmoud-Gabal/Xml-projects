package com.example.intentservice
import android.app.IntentService
import android.content.Intent
import android.util.Log

class IntentService : IntentService("My service") {
    init {
         instance = this
    }
    companion object {
        private lateinit var instance : com.example.intentservice.IntentService
        var isRunning = false

        fun stopIntentService(){
            Log.d("Service","Service is stopped")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning){
                Log.d("Service","Service is Running")
                Thread.sleep(1000)
            }
        }catch (e : InterruptedException){
            Thread.currentThread().interrupt()
        }
    }
}
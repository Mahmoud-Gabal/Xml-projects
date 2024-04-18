package com.example.intentserviceservice

import android.app.IntentService
import android.content.Intent
import android.nfc.Tag
import android.util.Log

class MyIntentService : IntentService("my service") {
    init {
        instance = this
    }
    companion object {
        private lateinit var instance : MyIntentService
        var isRunning = false
        fun stopIntentService(){
            Log.d("Intent Service","service is stopped")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("Intent Service", "service is running")
                Thread.sleep(1000)
            }
        }catch (e : InterruptedException){
            Thread.currentThread().interrupt()
        }
    }
}
package com.example.logintemplete

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcast:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state",false) ?: return
        if (isAirPlaneModeEnabled){
            Toast.makeText(context,"AirPlane mode is ON",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"AirPlane mode is OFF",Toast.LENGTH_LONG).show()

        }
    }
}
package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MybroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state",false) ?: return
        if (isAirplaneModeEnabled){
            Toast.makeText(context,"Airplane Mode is enabled",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Airplane Mode is disabled",Toast.LENGTH_LONG).show()

        }
    }
}
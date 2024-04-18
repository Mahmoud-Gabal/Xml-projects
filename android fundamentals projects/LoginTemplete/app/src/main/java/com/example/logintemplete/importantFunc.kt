package com.example.logintemplete

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity

open class broadcast(val receiver : MyBroadcast = MyBroadcast()) : AppCompatActivity(){
    //on stopping the activity, the broadcast receiver for airplane is off
    fun launch_broadcast(){
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
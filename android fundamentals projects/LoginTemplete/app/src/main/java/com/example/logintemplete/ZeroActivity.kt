package com.example.logintemplete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logintemplete.databinding.ActivityZeroBinding

class ZeroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityZeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        --------------------------------------------------------
        //        launch the broadcast receiver of airplane mode

//        Get into the login page
        GetIntoLoginPage()
    }
    private fun GetIntoLoginPage(){
        binding.layRobusta.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    //on stopping the activity, the broadcast receiver for airplane is off

}
package com.example.logintemplete

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.logintemplete.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    lateinit var receiver : MyBroadcast
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebase : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
//======================================================================
        binding.floatingActionButton2.setOnClickListener{
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
        firebase = FirebaseAuth.getInstance()
        binding.btnSignUp.setOnClickListener{
            val user = binding.etUserUp.text.toString()
            val pass = binding.etPassUp.text.toString()
            val email = binding.etEmailUp.text.toString()
            val confirmPass = binding.etConfirmUp.text.toString()
            if (user.isNotEmpty()&&pass.isNotEmpty()&&email.isNotEmpty()&&confirmPass.isNotEmpty()){
                if (pass == confirmPass){
                    firebase.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this,"Email created",Toast.LENGTH_SHORT).show()
                            Intent(this,MainActivity::class.java).also {startActivity(it)}


                        }else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                            Log.d("SignUP",it.exception.toString())
                        }
                    }
                }else{
                    Toast.makeText(this,"Password isn't matching !",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please fill empty places",Toast.LENGTH_SHORT).show()
            }
        }
        binding.LayHavingAccount.setOnClickListener {
            Intent(this,MainActivity::class.java).also { startActivity(it) }
        }

    }

}



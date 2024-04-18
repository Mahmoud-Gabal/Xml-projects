package com.example.logintemplete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.logintemplete.databinding.ActivityPhoneBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneActivity : AppCompatActivity() {
    private lateinit var selectedCountryCode : String
    private lateinit var number : String
    private lateinit var countryCode : String
    private lateinit var auth  : FirebaseAuth
    private lateinit var binding : ActivityPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fbFromPhone.setOnClickListener{
            Intent(this,MainActivity::class.java).also{ startActivity(it) }
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                 selectedCountryCode = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@PhoneActivity,"Please,select the country code",Toast.LENGTH_SHORT).show()
            }

        }
//        --------------------------------------------------------------------------
        auth = FirebaseAuth.getInstance()
        binding.progressBar.visibility = View.INVISIBLE
        binding.btnsendOTP.setOnClickListener {
             number = binding.etPhone.text.trim().toString()
             countryCode = binding.spinner.selectedItem.toString()
            if (number.isNotEmpty()){
                if (number.length == 10){
                    number = "+20$number"
                    binding.progressBar.visibility = View.VISIBLE
                    val options = PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(number) // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this) // Activity (for callback binding)
                        .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                        .build()
                    PhoneAuthProvider.verifyPhoneNumber(options)
                }else{
                    Toast.makeText(this,"please,Enter correct number",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"please,Enter a number",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this,"Authentication successfully",Toast.LENGTH_SHORT).show()
                    Intent(this,ProfileActivity::class.java).also { startActivity(it) }
                } else {
                    Log.d("TAG","signINWithPhoneAuthCredential : ${task.exception.toString()}")
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }
    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.

            if (e is FirebaseAuthInvalidCredentialsException) {
                Log.d("TAG","OnVerificationFailed : ${e.toString()}")
            } else if (e is FirebaseTooManyRequestsException) {
                Log.d("TAG","OnVerificationFailed : ${e.toString()}")
            } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
                Log.d("TAG","OnVerificationFailed : ${e.toString()}")
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken,
        ) {
            Intent(this@PhoneActivity,OptActivity::class.java).also {
                it.putExtra("otp",verificationId)
                it.putExtra("resend_token",token)
                it.putExtra("number",number)
                startActivity(it)
            }
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this,ProfileActivity::class.java).also { startActivity(it) }
        }
    }
}
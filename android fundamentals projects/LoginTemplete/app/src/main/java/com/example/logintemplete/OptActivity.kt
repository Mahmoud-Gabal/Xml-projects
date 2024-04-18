package com.example.logintemplete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.logintemplete.databinding.ActivityOptBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class OptActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOptBinding
    private lateinit var number: String
    private lateinit var auth: FirebaseAuth
    private lateinit var otp : String
    private lateinit var resend_token : PhoneAuthProvider.ForceResendingToken
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar2.visibility = View.INVISIBLE
        number = intent.getStringExtra("number").toString()
        otp = intent.getStringExtra("otp").toString()
        resend_token = intent.getParcelableExtra("resend_token")!!
        auth = FirebaseAuth.getInstance()
        editTextChangeListener()
        resendVisibility()
        binding.btnVerify.setOnClickListener {
            val typedOTP =
                binding.d1.text.toString()+
                binding.d2.text.toString()+
                binding.d3.text.toString()+
                binding.d4.text.toString()+
                binding.d5.text.toString()+
                binding.d6.text.toString()
            if (typedOTP.isNotEmpty()){
                if (typedOTP.length == 6){
                    val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(otp,typedOTP)
                    binding.progressBar2.visibility = View.VISIBLE
                    signInWithPhoneAuthCredential(credential)
                }else{
                    Toast.makeText(this,"Enter correct OTP",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"please, enter OTP",Toast.LENGTH_SHORT).show()
            }
        }
        binding.txtResendOtp.setOnClickListener {
            resendVerificationCode()
            resendVisibility()
        }
    }
    private fun resendVisibility(){
        binding.txtResendOtp.visibility = View.INVISIBLE
        binding.txtResendOtp.isEnabled = false
        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            binding.txtResendOtp.visibility = View.VISIBLE
            binding.txtResendOtp.isEnabled = true
        },60000)
    }
    private fun resendVerificationCode(){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .setForceResendingToken(resend_token)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
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
            otp = verificationId
            resend_token = token
        }
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    binding.progressBar2.visibility = View.VISIBLE
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
    private fun editTextChangeListener(){
        binding.d1.addTextChangedListener(EditTextWatcher(binding.d1))
        binding.d2.addTextChangedListener(EditTextWatcher(binding.d2))
        binding.d3.addTextChangedListener(EditTextWatcher(binding.d3))
        binding.d4.addTextChangedListener(EditTextWatcher(binding.d4))
        binding.d5.addTextChangedListener(EditTextWatcher(binding.d5))
        binding.d6.addTextChangedListener(EditTextWatcher(binding.d6))
    }
    inner class EditTextWatcher(val view: View) : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            val text = s.toString()
            when(view.id){
                R.id.d1 -> if (text.length == 1) binding.d2.requestFocus()
                R.id.d2 -> if (text.length == 1) binding.d3.requestFocus() else if (text.isEmpty()) binding.d1.requestFocus()
                R.id.d3 -> if (text.length == 1) binding.d4.requestFocus() else if (text.isEmpty()) binding.d2.requestFocus()
                R.id.d4 -> if (text.length == 1) binding.d5.requestFocus() else if (text.isEmpty()) binding.d3.requestFocus()
                R.id.d5 -> if (text.length == 1) binding.d6.requestFocus() else if (text.isEmpty()) binding.d4.requestFocus()
                R.id.d6 -> if (text.isEmpty()) binding.d5.requestFocus()
            }
        }
    }
}
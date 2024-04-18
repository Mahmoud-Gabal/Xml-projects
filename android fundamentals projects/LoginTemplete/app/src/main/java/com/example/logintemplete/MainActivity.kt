package com.example.logintemplete

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.logintemplete.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity(){
    lateinit var receiver : MyBroadcast
    private lateinit var binding : ActivityMainBinding
    private lateinit var firebase: FirebaseAuth
    private lateinit var gsc : GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// ====================================================================
        binding.floatingActionButton.setOnClickListener {
            Intent(this,ZeroActivity::class.java).also{
                startActivity(it)
            }
        }
        firebase = FirebaseAuth.getInstance()
        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmialIN.text.toString()
            val pass = binding.etPassIN.text.toString()
            if (email.isNotEmpty()&&pass.isNotEmpty()){
                firebase.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful){
                        Intent(this,ProfileActivity::class.java).also {
                            it.putExtra("extra_email_from_signin",email)
                            startActivity(it)
                        }
                    }else {
                        Log.d("SignIn",it.exception.toString())
                        try {
                            throw it.exception!!
                        }catch (e: FirebaseAuthInvalidUserException){
                            binding.etEmialIN.setError("Invalid User!")
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                binding.etEmialIN.requestFocus()
                            }
                        }catch (e: FirebaseAuthInvalidCredentialsException){
                            binding.etEmialIN.setError("Username or password is wrong !")
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                binding.etEmialIN.requestFocus()
                            }
                        }
                    }
                }
            }else{
                Toast.makeText(this,"Please fill empty places",Toast.LENGTH_SHORT).show()
            }
        }
        binding.LayNotHavingAccount.setOnClickListener {
            Intent(this,SignUpActivity::class.java).also { startActivity(it) }
        }


        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        gsc = GoogleSignIn.getClient(this,gso)
        binding.goToSignInGoogle.setOnClickListener {
            signInGoogle()
        }
        binding.SignInPhone.setOnClickListener {
            Intent(this,PhoneActivity::class.java).also { startActivity(it) }
        }
    }
    private fun signInGoogle(){
        var signInIntent = gsc.signInIntent
        launcher.launch(signInIntent)
    }
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount ?= task.result
            if (account != null){
                updateUI(account)
            }
        }else Toast.makeText(this,task.exception.toString(),Toast.LENGTH_SHORT).show()
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        firebase.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                Intent(this,ProfileActivity::class.java).also { startActivity(it) }
            }else Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
        }
    }

}
package com.example.logintemplete

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.logintemplete.databinding.ActivityGoogleBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class GoogleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGoogleBinding
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var gsc  : GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        gsc = GoogleSignIn.getClient(this,gso)
        binding.signInGo.setOnClickListener {
            signInGoogle()
        }
    }
    private fun signInGoogle(){
        val signInIntent = gsc.signInIntent
        launcher.launch(signInIntent)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
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
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                Intent(this,ProfileActivity::class.java).also {
                    it.putExtra("EXTRA_EMAIL_FROM_GOOGLE",account.email)
                    it.putExtra("EXTRA_NAME_FROM_GOOGLE",account.displayName)
                    startActivity(it)
                }
            }else Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}
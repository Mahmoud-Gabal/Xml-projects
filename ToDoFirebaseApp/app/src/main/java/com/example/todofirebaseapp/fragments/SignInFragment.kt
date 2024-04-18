package com.example.todofirebaseapp.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.todofirebaseapp.R
import com.example.todofirebaseapp.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var navcontroller: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        navcontroller = Navigation.findNavController(view)
        binding.authtext.setOnClickListener {
            navcontroller.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        binding.btnnext.setOnClickListener {
            val email = binding.etEmailSignIn.text.toString().trim()
            val pass = binding.etpassSignIn.text.toString().trim()
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        navcontroller.navigate(R.id.action_signInFragment_to_homeFragment)
                    } else {
                        try {
                            throw it.exception!!
                        }catch (e: FirebaseAuthInvalidUserException){
                            binding.etEmailSignIn.setError("Invalid User!")
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                binding.etEmailSignIn.requestFocus()
                            }
                        }catch (e: FirebaseAuthInvalidCredentialsException){
                            binding.etEmailSignIn.setError("Username or password is wrong !")
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                binding.etEmailSignIn.requestFocus()
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(context, "Please fill empty space", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
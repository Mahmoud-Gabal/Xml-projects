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
import com.example.todofirebaseapp.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var navcontroller: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        navcontroller = Navigation.findNavController(view)
        binding.authtext.setOnClickListener {
            navcontroller.navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        binding.btnnext.setOnClickListener {
            val email = binding.etEmailSignUp.text.toString().trim()
            val pass = binding.etpassSignUp.text.toString().trim()
            val verifyPass = binding.etRetypePassSignUp.text.toString().trim()
            if (email.isNotEmpty() && pass.isNotEmpty()&&verifyPass.isNotEmpty()) {
                if (pass==verifyPass){
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(context,"Email is created",Toast.LENGTH_SHORT).show()
                            navcontroller.navigate(R.id.action_signUpFragment_to_signInFragment)
                        } else {
                            Toast.makeText(context,it.exception?.message,Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(context,"password is not matching",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please fill empty space", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
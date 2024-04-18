package com.example.todofirebaseapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.todofirebaseapp.R
import com.example.todofirebaseapp.databinding.FragmentPopUpBinding
import com.google.android.material.textfield.TextInputEditText


class PopUpFragment : DialogFragment() {
    private lateinit var binding: FragmentPopUpBinding
    private lateinit var listener: dialogPopUpListener
    fun setListener(listener: dialogPopUpListener){
        this.listener = listener
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.todoNextBtn.setOnClickListener {
            val task =binding.todoEt.text.toString()
            if (task.isNotEmpty()){
                listener.onSavetask(task,binding.todoEt)
            }else{
                Toast.makeText(context,"please add a task",Toast.LENGTH_SHORT).show()
            }
        }
        binding.todoClose.setOnClickListener {
            dismiss()
        }
    }
    interface dialogPopUpListener{
        fun onSavetask(task : String,tasket : TextInputEditText)
    }
}
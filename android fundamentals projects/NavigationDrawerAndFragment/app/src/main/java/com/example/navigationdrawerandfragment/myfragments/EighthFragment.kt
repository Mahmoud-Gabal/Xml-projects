package com.example.navigationdrawerandfragment.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationdrawerandfragment.R
import com.example.navigationdrawerandfragment.databinding.FragmentEighthBinding
import com.example.navigationdrawerandfragment.databinding.FragmentFirstBinding

class EighthFragment : Fragment(R.layout.fragment_eighth) {
    private lateinit var binding: FragmentEighthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEighthBinding.inflate(inflater, container, false)
        return binding.root
    }
}
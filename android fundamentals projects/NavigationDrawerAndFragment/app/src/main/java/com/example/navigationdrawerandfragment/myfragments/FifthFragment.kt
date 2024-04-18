package com.example.navigationdrawerandfragment.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationdrawerandfragment.R
import com.example.navigationdrawerandfragment.databinding.FragmentFifthBinding
import com.example.navigationdrawerandfragment.databinding.FragmentFirstBinding

class FifthFragment : Fragment(R.layout.fragment_fifth) {
    private lateinit var binding: FragmentFifthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }
}
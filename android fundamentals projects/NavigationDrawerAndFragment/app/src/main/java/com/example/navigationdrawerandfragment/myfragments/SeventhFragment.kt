package com.example.navigationdrawerandfragment.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationdrawerandfragment.R
import com.example.navigationdrawerandfragment.databinding.FragmentFirstBinding
import com.example.navigationdrawerandfragment.databinding.FragmentSeventhBinding

class SeventhFragment : Fragment(R.layout.fragment_seventh) {
    private lateinit var binding: FragmentSeventhBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeventhBinding.inflate(inflater, container, false)
        return binding.root
    }
}
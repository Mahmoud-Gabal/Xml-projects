package com.example.kitchen_menues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kitchen_menues.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        var datalist = listOf<DataClass>(
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!"),
            DataClass(R.drawable.logo1,"this is so hooot burger!!")
        )
        var adaper1 = adapterOne(datalist)
        binding.recyclesecond.adapter = adaper1
        binding.recyclesecond.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}
package com.example.kitchen_menues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kitchen_menues.databinding.FragmentFirstBinding
import androidx.recyclerview.widget.LinearLayoutManager

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        var datalist = listOf<DataClass>(
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!"),
            DataClass(R.drawable.burger2,"this is so hooot burger!!")
        )
        var adaper1 = adapterOne(datalist)
        binding.recycleFirst.adapter = adaper1
        binding.recycleFirst.layoutManager = LinearLayoutManager(context)
        return binding.root
    }


}
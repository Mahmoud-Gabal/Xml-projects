package com.example.kitchen_menues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kitchen_menues.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        var datalist = listOf<DataClass>(
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!"),
            DataClass(R.drawable.download,"this is so hooot burger!!")
        )
        var adaper1 = adapterOne(datalist)
        binding.recyclethird.adapter = adaper1
        binding.recyclethird.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}
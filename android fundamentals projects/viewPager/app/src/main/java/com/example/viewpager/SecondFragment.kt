package com.example.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        var datalist2 = listOf<recycleDataClass>(
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
            recycleDataClass(R.drawable.logo1,"this is so hot burger!!"),
        )
        var adapter = myAdapter(datalist2)
        binding.recycleView2.adapter = adapter
        binding.recycleView2.layoutManager = LinearLayoutManager(context)
        var imgList = listOf<Int>(
            R.drawable.m1,
            R.drawable.m2,
            R.drawable.m3,
            R.drawable.m4,
            R.drawable.m5,
            R.drawable.m6,
            R.drawable.m7,
        )
        var ADAPTER_of_ViewPager = adapterForViewPager(imgList)
        binding.Viewpager2.adapter = ADAPTER_of_ViewPager
        return binding.root
    }

}
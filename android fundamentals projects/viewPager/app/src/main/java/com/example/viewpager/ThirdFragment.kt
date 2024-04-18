package com.example.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var _binding : FragmentThirdBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        var datalist3 = listOf<recycleDataClass>(
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
            recycleDataClass(R.drawable.download,"this is so hot burger!!"),
        )
        var adapter = myAdapter(datalist3)
        binding.recycleView3.adapter = adapter
        binding.recycleView3.layoutManager = LinearLayoutManager(context)
        var imgList = listOf<Int>(
            R.drawable.n1,
            R.drawable.n2,
            R.drawable.n3,
            R.drawable.n4,
            R.drawable.n5,
        )
        var ADAPTER_of_ViewPager = adapterForViewPager(imgList)
        binding.Viewpager3.adapter = ADAPTER_of_ViewPager
        return binding.root
    }

}
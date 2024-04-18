package com.example.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        var datalist = listOf<recycleDataClass>(
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
            recycleDataClass(R.drawable.burger2,"this is so hot burger!!"),
        )
        var adapter = myAdapter(datalist)
        binding.recycleView1.adapter = adapter
        binding.recycleView1.layoutManager = LinearLayoutManager(context)
        var imgList = listOf<Int>(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            )
        var ADAPTER_of_ViewPager = adapterForViewPager(imgList)
        binding.Viewpager1.adapter = ADAPTER_of_ViewPager
        binding.Viewpager1.setUserInputEnabled(false)
        return binding.root
    }

}
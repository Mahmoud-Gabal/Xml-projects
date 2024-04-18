package com.example.tablayoutviewpagernavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.tablayoutviewpagernavigationview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle = ActionBarDrawerToggle(this,binding.drawlayout,R.string.open,R.string.close)
        binding.drawlayout.addDrawerListener(toggle)
        toggle.syncState()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navViewId.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.catOneId -> Toast.makeText(applicationContext,"you clicked Category One",Toast.LENGTH_SHORT).show()
                R.id.catTwoId -> Toast.makeText(applicationContext,"you clicked Category Two",Toast.LENGTH_SHORT).show()
                R.id.catThreeId -> Toast.makeText(applicationContext,"you clicked Category Three",Toast.LENGTH_SHORT).show()
            }
            true
        }
//    ===================================================================
        var dataList = listOf<Int>(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5
        )
        var adapter = ViewPagerAdapter(dataList)
        binding.viewPagerId.adapter = adapter
        TabLayoutMediator(binding.tablayout,binding.viewPagerId){tab,position ->
            tab.text = "Animal ${position+1}"
        }.attach()
        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"this is ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
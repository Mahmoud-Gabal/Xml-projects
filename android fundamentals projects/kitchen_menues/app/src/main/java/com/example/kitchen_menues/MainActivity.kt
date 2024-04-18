package com.example.kitchen_menues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kitchen_menues.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        -------------------------------------------------------------
        binding.bottomNavigationView.menu.findItem(R.id.menu2).setChecked(true)
        seCurrentFragment(SecondFragment())
        badge_yes()
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when ( it.itemId ){
                R.id.menu1 -> {
                    seCurrentFragment(FirstFragment())
                    badge_No()
                }
                R.id.menu2 -> seCurrentFragment(SecondFragment())
                R.id.menu3 -> seCurrentFragment(ThirdFragment())
            }
            true
        }
    }
    fun seCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameALayout,fragment)
            commit()
        }
    }
    fun badge_yes(){
        binding.bottomNavigationView.getOrCreateBadge(R.id.menu1).apply {
            number = 10
            isVisible = true
        }
    }
    fun badge_No(){
        binding.bottomNavigationView.getOrCreateBadge(R.id.menu1).apply {
            number = 0
            isVisible = false
        }
    }
}
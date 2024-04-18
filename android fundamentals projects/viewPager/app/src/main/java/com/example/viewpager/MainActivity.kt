package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        --------------------------------------------------------
        setCurrentFragment(FirstFragment())
        badge_yes_forCAt2()
        binding.bottomNavigationView.menu.findItem(R.id.firstCatId).setChecked(true)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.firstCatId -> setCurrentFragment(FirstFragment())
                R.id.secondCatId -> {
                    setCurrentFragment(SecondFragment())
                    badge_No_forCat2()
                }
                R.id.thirdCatId -> setCurrentFragment(ThirdFragment())
            }
            true
        }

    }
    fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }
    fun badge_yes_forCAt2(){
        binding.bottomNavigationView.getOrCreateBadge(R.id.secondCatId).apply {
            number = 10
            isVisible = true
        }
    }
    fun badge_No_forCat2(){
        binding.bottomNavigationView.getOrCreateBadge(R.id.secondCatId).apply {
            number = 0
            isVisible = false
        }
    }
}
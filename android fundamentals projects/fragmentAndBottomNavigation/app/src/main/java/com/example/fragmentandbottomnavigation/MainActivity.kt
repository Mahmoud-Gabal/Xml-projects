package com.example.fragmentandbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import com.example.fragmentandbottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//---------------------------------------------------------------------------------------
        setCurrentFragment(FirstFragment())
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeOFmenu -> setCurrentFragment(FirstFragment())
                R.id.messageOFmenu -> setCurrentFragment(SecondFragment())
                R.id.contactsOFmenu -> setCurrentFragment(ThirdFragment())
            }
            true
        }
        binding.bottomNavigationView.getOrCreateBadge(R.id.messageOFmenu).apply {
            number = 10
            isVisible = true
        }

    }
    fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }
}
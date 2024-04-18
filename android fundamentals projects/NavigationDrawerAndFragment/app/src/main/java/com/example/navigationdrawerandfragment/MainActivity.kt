package com.example.navigationdrawerandfragment

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.navigationdrawerandfragment.databinding.ActivityMainBinding
import com.example.navigationdrawerandfragment.myfragments.EighthFragment
import com.example.navigationdrawerandfragment.myfragments.FifthFragment
import com.example.navigationdrawerandfragment.myfragments.FirstFragment
import com.example.navigationdrawerandfragment.myfragments.FourthFragment
import com.example.navigationdrawerandfragment.myfragments.NinthFragment
import com.example.navigationdrawerandfragment.myfragments.SecondFragment
import com.example.navigationdrawerandfragment.myfragments.SeventhFragment
import com.example.navigationdrawerandfragment.myfragments.SixthFragment
import com.example.navigationdrawerandfragment.myfragments.TenthFragment
import com.example.navigationdrawerandfragment.myfragments.ThirdFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle = ActionBarDrawerToggle(this,binding.drawlayout,R.string.open, R.string.close)
        binding.drawlayout.addDrawerListener(toggle)
        toggle.syncState()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.navigationId.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.pic1 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,FirstFragment())
                    commit()
                }
                R.id.pic2 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,SecondFragment())
                    commit()
                }
                R.id.pic3 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,ThirdFragment())
                    commit()
                }
                R.id.pic4 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,FourthFragment())
                    commit()
                }
                R.id.pic5 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,FifthFragment())
                    commit()
                }
                R.id.pic6 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,SixthFragment())
                    commit()
                }
                R.id.pic7 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,SeventhFragment())
                    commit()
                }
                R.id.pic8 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,EighthFragment())
                    commit()
                }
                R.id.pic9 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,NinthFragment())
                    commit()
                }
                R.id.pic10 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.framelayout,TenthFragment())
                    commit()
                }

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
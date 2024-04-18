package com.example.logintemplete

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.logintemplete.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var receiver : MyBroadcast
    lateinit var toggle : ActionBarDrawerToggle
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        toggle = ActionBarDrawerToggle(this,binding.drawlayout,R.string.open,R.string.close)
        binding.drawlayout.addDrawerListener(toggle)
        toggle.syncState()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navigationId.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Profile -> Toast.makeText(applicationContext,"you clicked profile",
                    Toast.LENGTH_SHORT).show()
                R.id.Chat -> Toast.makeText(applicationContext,"you clicked chat",
                    Toast.LENGTH_SHORT).show()
                R.id.Events -> Toast.makeText(applicationContext,"you clicked events",
                    Toast.LENGTH_SHORT).show()
                R.id.Friends -> Toast.makeText(applicationContext,"you clicked friends",
                    Toast.LENGTH_SHORT).show()
                R.id.Favourites -> Toast.makeText(applicationContext,"you clicked favourites",
                    Toast.LENGTH_SHORT).show()
                R.id.Privacy -> Toast.makeText(applicationContext,"you clicked privacy",
                    Toast.LENGTH_SHORT).show()
                R.id.Help -> Toast.makeText(applicationContext,"you clicked help",
                    Toast.LENGTH_SHORT).show()
                R.id.Groups -> Toast.makeText(applicationContext,"you clicked groups",
                    Toast.LENGTH_SHORT).show()
                R.id.Saved -> Toast.makeText(applicationContext,"you clicked saved",
                    Toast.LENGTH_SHORT).show()
                R.id.Logout -> {
                    auth.signOut()
                    Intent(this,MainActivity::class.java).also { startActivity(it) }
                }

            }
            true
        }
//        launch the recyclerView
        var dataList = listOf<viewPagerAdapter>(
            viewPagerAdapter(listOf(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5)),
            viewPagerAdapter(listOf(R.drawable.n1,R.drawable.n2,R.drawable.n3,R.drawable.n4)),
            viewPagerAdapter(listOf(R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4))
        )
        var adapter = RecyclerViewAdapter(dataList)
        binding.recyclerViewId.adapter = adapter
        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
//        launch the broadcast receiver of airplane mode
        receiver = MyBroadcast()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
    }
//on stopping the activity, the broadcast receiver for airplane is off
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
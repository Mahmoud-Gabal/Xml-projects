package com.example.mykitchen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.mykitchen.databinding.ActivityMain0Binding
import com.example.mykitchen.databinding.ActivityMainBinding
import java.util.*

class MainActivity0 : AppCompatActivity() {
    private lateinit var binding: ActivityMain0Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain0Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        ---------------------------------------------------------------------------
        binding.btnaccess.setOnClickListener {
            requestPermissions()
        }
        binding.btngo.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
        setSupportActionBar(binding.toolbar)
    }
    private fun has_internet()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
    private fun has_coarseLocation()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    private fun has_backgroundLocation()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    fun has_storage()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    private fun requestPermissions(){
        var permissionsToRequest = mutableListOf<String>()
        if (!has_internet()) permissionsToRequest.add(Manifest.permission.INTERNET)
        if (!has_coarseLocation()) permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        if (!has_backgroundLocation()) permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        if (!has_storage()) permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permissionsToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissionsToRequest.toTypedArray(),0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("permissions","${permissions[i]} granted")
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.call -> Toast.makeText(this,"You Added a Call",Toast.LENGTH_SHORT).show()
            R.id.setting -> Toast.makeText(this,"You opened settings",Toast.LENGTH_SHORT).show()
            R.id.close -> finish()
        }
        return true
    }
}
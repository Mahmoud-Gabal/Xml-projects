package com.example.mykitchen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mykitchen.databinding.ActivityMain2Binding
import com.example.mykitchen.databinding.ActivityMainBinding
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        ------------------------------------------------------------
        var name = intent.getStringExtra("EXTRA_NAME")
        binding.headtxt.text = "Select for your burger,Mr $name"
        var num = 0
        binding.btnplus.setOnClickListener {
            num++
            binding.textnum.text = "N of orders :  $num"
        }
        binding.btnminus.setOnClickListener {
            if (num == 0) binding.textnum.text = "N of orders :  $num"
            else{
                num--
                binding.textnum.text = "N of orders :  $num"
            }
        }
        binding.add.setOnClickListener {
            if (binding.radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(applicationContext,"please select the meat ",Toast.LENGTH_SHORT).show()
            }else {
                var meat_id = binding.radioGroup.checkedRadioButtonId
                var meat = findViewById<RadioButton>(meat_id)
                var salad = binding.checksalad.isChecked
                var cheese = binding.checkcheese.isChecked
                var onions = binding.checkonions.isChecked
                binding.textorder.text = "your ordrer is :($num)\n${meat.text} burger + " +
                        (if (salad) "salad" else "") +
                        (if (cheese) "+cheese" else "") +
                        (if (onions) "+onions" else "")
                showCustomToast()
            }

        }
        binding.buy.setOnClickListener {
            Toast.makeText(applicationContext,"your order is bought\nIt will be ready in 15min",Toast.LENGTH_LONG).show()
            Intent(this,MainActivity3::class.java).also {
                it.putExtra("EXTRA_NAME",name)
                startActivity(it)
            }
        }

    }
    private fun showCustomToast(){
        val custom_view = findViewById<ConstraintLayout>(R.id.custom)
        val layout = layoutInflater.inflate(R.layout.custom_toast,custom_view)
        with(Toast(applicationContext)){
            duration = Toast.LENGTH_LONG
            setGravity(Gravity.BOTTOM,0,0)
            view =layout
            show()
        }
    }
}
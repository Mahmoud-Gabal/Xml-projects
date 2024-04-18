package com.example.demoes
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.demoes.databinding.ActivityMainBinding
import java.util.*
    class MainActivity :AppCompatActivity(){
        private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
//            ------------------------------------------------------------------------------
            var toasttext = ""
            val days = arrayOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
                "20","21","22","23","24","25","26","27","28","29","30","31")
            val years = arrayOf("2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012",
                "2013","2014","2015","2016","2017","2018","2019","2020")
            val yearAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,years)
            binding.syear.adapter = yearAdapter
            val daysAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,days)
            binding.sday.adapter = daysAdapter
            binding.scountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            
                override fun onItemSelected(
                    adapterview: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    Toast.makeText(this@MainActivity,"${adapterview?.getItemAtPosition(position).toString()}",Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
                
            }
            binding.sday.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

                override fun onItemSelected(
                    adapterview: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity,"${adapterview?.getItemAtPosition(position).toString()}",Toast.LENGTH_LONG).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
            binding.smonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

                override fun onItemSelected(
                    adapterview: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long,

                ){
                    Toast.makeText(this@MainActivity,"${adapterview?.getItemAtPosition(position).toString()}",Toast.LENGTH_LONG).show()


                }


                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

            binding.syear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

                override fun onItemSelected(
                    adapterview: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity,"${adapterview?.getItemAtPosition(position).toString()}",Toast.LENGTH_LONG).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
            var hobbies =arrayOf("Football","Basketball","Swimming")
//            -------------------------------------------------------------

//            -----------------------------------------------------------------
            val show_multiChoice = AlertDialog.Builder(this)
                .setTitle("HOBBIES")
                .setIcon(R.drawable.ic_notification)
                .setMultiChoiceItems(hobbies, booleanArrayOf(false,false,false)){dialog,i,ischecked ->
                    var checking = "your hobbies are : "
                    if (ischecked) {
                        checking += " (${hobbies[i]}) "

                    }
                    else {
                        checking.replace(" (${hobbies[i]}) ","")

                    }

                }
                .setPositiveButton("Yes"){_,_ ->
                    Toast.makeText(this,"you accepted",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel"){_,_ ->
                    Toast.makeText(this,"you canceled",Toast.LENGTH_SHORT).show()
                }.create()

            binding.btnhobbies.setOnClickListener {
                show_multiChoice.show()
            }
            binding.btnapply.setOnClickListener {

                var first_name = binding.editfirstname.text.toString()
                var last_name = binding.editlastname.text.toString()
                var address = binding.editaddress.text.toString()
                var phone = binding.editphone.text.toString()
                var email = binding.editemail.text.toString()
                var faculty = binding.editfaculty.text.toString()
                toasttext = "You are $first_name $last_name." +
                        "Your phone is $phone.Your email is $email.You are studying at $faculty.you live in $address"
                Toast.makeText(this,toasttext,Toast.LENGTH_LONG).show()

            }
            binding.btnContinue.setOnClickListener {
                Intent(this,MainActivity2::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
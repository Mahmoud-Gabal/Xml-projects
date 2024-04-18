package com.example.todofirebaseapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofirebaseapp.R
import com.example.todofirebaseapp.adapters.recycleAdapter
import com.example.todofirebaseapp.databinding.FragmentHomeBinding
import com.example.todofirebaseapp.dataclasses.todoDataClass
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment(R.layout.fragment_home), PopUpFragment.dialogPopUpListener,
    recycleAdapter.AdapterButtonsListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var navController: NavController
    private lateinit var popUpFragment: PopUpFragment
    private lateinit var list : MutableList<todoDataClass>
    private lateinit var adapter : recycleAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        databaseReference =
             FirebaseDatabase.getInstance().reference.child("tasks").child(auth.currentUser!!.uid)
        navController = Navigation.findNavController(view)
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            navController.navigate(R.id.action_homeFragment_to_signInFragment)

//            -------------------------------------------------------
        }
        binding.btnAddTask.setOnClickListener {
            popUpFragment = PopUpFragment()
            popUpFragment.setListener(this)
            popUpFragment.show(childFragmentManager,"AddingPop")
        }
        list = mutableListOf<todoDataClass>()
        adapter = recycleAdapter(list)
        adapter.setListener(this)
        binding.MyRecycleView.layoutManager = LinearLayoutManager(context)
        binding.MyRecycleView.adapter = adapter
        getDataFromFirebase()
    }

    private fun getDataFromFirebase(){
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (taskSnapshot in snapshot.children){
                    val todoTask = taskSnapshot.key?.let {
                        todoDataClass(it,taskSnapshot.value.toString())
                    }
                    if (todoTask != null){
                        list.add(todoTask)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.message,Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onSavetask(task: String, tasket: TextInputEditText) {
        databaseReference.push().setValue(task).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"Task saved successfully",Toast.LENGTH_SHORT).show()
                tasket.text = null
            }else{
                Toast.makeText(context,it.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
        popUpFragment.dismiss()
    }

    override fun OnBtnEditListener(todoDataClass: todoDataClass) {
        TODO("Not yet implemented")
    }

    override fun OnBtnDeleteListener(todoDataClass: todoDataClass) {
        databaseReference.child(todoDataClass.taskId).removeValue().addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"Task removed successfully",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,it.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }
}
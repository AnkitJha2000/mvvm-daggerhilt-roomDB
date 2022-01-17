package com.example.mvvmdaggerhiltroomDB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdaggerhiltroomDB.adapter.UserAdapter
import com.example.mvvmdaggerhiltroomDB.databinding.ActivityMainBinding
import com.example.mvvmdaggerhiltroomDB.model.User
import com.example.mvvmdaggerhiltroomDB.viewModel.UserViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView();
        userViewModel.getUserData.observe(this , Observer {
            userAdapter.setData(it as ArrayList<User>)
        })

        binding.save.setOnClickListener{
            insertIntoRoom()
        }

    }

    private fun insertIntoRoom() {
        val nName = binding.name.text.toString().trim()
        val nAge = binding.age.text.toString().trim()

        if(!TextUtils.isEmpty(nName) && !TextUtils.isEmpty(nAge))
        {
            val user = User(nName,nAge.toInt())
            userViewModel.insert(user)
            Toast.makeText(this , "Data inserted", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this , "Either of the field is empty!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(this, userList = ArrayList())
        binding.recyclerView.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}
package com.dhanshri.coroutine_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dhanshri.coroutine_kotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private lateinit var viewModel: SecondActicityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        viewModel = ViewModelProvider(this).get(SecondActicityViewModel::class.java)
        viewModel.getUserData()
        viewModel.users.observe(this, Observer {myUsers ->
            myUsers?.forEach {
                Log.d("MyTag"," name is ${it.name}")
            }
        })

    }
}
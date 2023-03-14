package com.dhanshri.coroutine_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var btnDownloadUserData : Button
    private lateinit var btnCount : Button
    private lateinit var tvCount : TextView
    private lateinit var tvuserMessage : TextView
    private lateinit var btnNext : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)
        tvuserMessage = findViewById(R.id.tvUserMessage)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main  ).launch{
//                tvuserMessage.text = UserDataManager().getTotalUserCount().toString()
                tvuserMessage.text = UserDataManager2().getTotalUserCount().toString()
//                downloadUserData()
            }

        }


        CoroutineScope(Dispatchers.IO).launch {
            Log.i("myTag","Calculation started ....")
            val stock1 = async {
                getStock1()
            }
            val stock2 = async {
                getStock2()
            }
            val total = stock1.await() + stock2.await()
            Log.i("myTag","Total is $total")
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}

private suspend fun getStock1(): Int{
    delay(10000)
    Log.i("myTag", " Stock 1 returned")
    return 55000
}
private suspend fun getStock2(): Int{
    delay(8000)
    Log.i("myTag", " Stock 2 returned")
    return 35000
}
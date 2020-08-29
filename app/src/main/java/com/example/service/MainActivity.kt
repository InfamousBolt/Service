package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartService.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                tvServiceStatus.text="Service is Running..."
            }
        }

        btnStopService.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                tvServiceStatus.text="Service is not Running..."
            }
        }

        btnSend.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val dataString=etData.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
                tvServiceStatus.text="Service is Running..."
            }
        }

    }

    override fun onDestroy() {
        Log.d("MyService","App is destroyed")
        super.onDestroy()
    }
}
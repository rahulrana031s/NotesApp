package com.example.notesapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.databinding.ActivityServicesBinding
import com.example.notesapp.reciver.MyBroadcast
import com.example.notesapp.services.MyService

class Services : AppCompatActivity() {

    lateinit var _binding: ActivityServicesBinding
    private lateinit var viewModel: ServiceViewModal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityServicesBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)


        viewModel = ViewModelProvider(this).get(ServiceViewModal::class.java)

        viewModel.setCount()
        viewModel.userLiveData.observe(this, Observer {

        })


            val alermManager  = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,MyBroadcast::class.java)
        var pendingIntent = PendingIntent.getBroadcast(this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        alermManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000,pendingIntent)

//        callService()
        _binding.button2.setOnClickListener {
            stopService(Intent(this@Services,MyService::class.java))
        }
    }

    private fun callService() {
        startService(Intent(this@Services,MyService::class.java))
    }

}
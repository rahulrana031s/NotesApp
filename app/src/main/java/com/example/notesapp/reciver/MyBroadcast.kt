package com.example.notesapp.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import com.example.notesapp.services.MyService


class MyBroadcast : BroadcastReceiver() {
    var mediaPlayer : MediaPlayer? = null


    override fun onReceive(context: Context?, p1: Intent?) {

        val intent= Intent(context,MyService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context!!.startForegroundService(intent)
        } else {
            context!!.startService( intent)
        }
//        context?.startService(intent)


//        mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI)
//        mediaPlayer?.isLooping = true
//        mediaPlayer?.start()
    }
}
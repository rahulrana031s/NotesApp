package com.example.notesapp.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService: Service() {

    var mediaPlayer : MediaPlayer? = null

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_NOTIFICATION_URI)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()


        return START_NOT_STICKY
    }

    override fun onDestroy() {
        mediaPlayer?.start()
        super.onDestroy()
    }
}
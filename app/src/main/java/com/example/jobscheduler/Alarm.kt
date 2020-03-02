package com.example.jobscheduler

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings

class Alarm: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        //can be used to play in loop
        var media : MediaPlayer = MediaPlayer.create(p0, Settings.System.DEFAULT_RINGTONE_URI)
        media.start()

    }
}
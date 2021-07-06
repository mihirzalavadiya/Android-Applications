package com.example.myalarm

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Vibrator


class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val vibrator : Vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(2000)

        val notification : Notification = Notification.Builder(context)
            .setContentTitle("Alarm is ON")
            .setContentText("You had set up the alarm")
            .setSmallIcon(R.mipmap.ic_launcher).build()

        val manager : NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notification.flags != Notification.FLAG_AUTO_CANCEL
        manager.notify(0, notification)

        val alert : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val r : Ringtone = RingtoneManager.getRingtone(context, alert)
        r.play()
    }
}
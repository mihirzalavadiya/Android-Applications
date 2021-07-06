package com.example.myalarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var mHour : Int = 0
    var mMin : Int = 0
    var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePicker.setOnTimeChangedListener(TimePicker.OnTimeChangedListener { view, hourOfDay, minute ->
            mHour = hourOfDay
            mMin = minute
            showTime.setText(showTime.getText().toString() + " " + mHour + " " + mMin)
        })

        setAlarm.setOnClickListener { 
            setTimer()
        }
    }

    fun setTimer() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val date = Date()

        val calAlarm = Calendar.getInstance()
        val calNow = Calendar.getInstance()

        calNow.setTime(date)
        calAlarm.setTime(date)

        calAlarm.set(Calendar.HOUR_OF_DAY, mHour)
        calAlarm.set(Calendar.MINUTE, mMin)
        calAlarm.set(Calendar.SECOND, 0)

        if (calAlarm.before(calNow)) {
            calAlarm.add(Calendar.DATE,1)
        }

        val intent = Intent(this, MyBroadcastReceiver::class.java)
        val pendingIntent : PendingIntent = PendingIntent.getBroadcast(this, 24444, intent, 0)
        alarmManager.set(AlarmManager.RTC_WAKEUP, calAlarm.getTimeInMillis(), pendingIntent)


    }
}
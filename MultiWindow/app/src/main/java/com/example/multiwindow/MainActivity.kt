package com.example.multiwindow

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_openActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)

            val rect = Rect(0, 0, 100, 100)
            val options = ActivityOptions.makeBasic()
            val bounds : ActivityOptions = options.setLaunchBounds(rect)
            startActivity(intent)
        }
    }
}
package com.example.videoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var statusVedio = findViewById<VideoView>(R.id.videoView)

        var handler1 = Handler()
        handler1.postDelayed({
            statusVedio.setVideoPath("android.resource://" + packageName + "/" + R.raw.video1)
            var mediaController = MediaController(this)
            statusVedio.setMediaController(mediaController)
            mediaController.setAnchorView(statusVedio)
            statusVedio.start()
        }, 1)

        handler1 = Handler()
        handler1.postDelayed({
            statusVedio.setVideoPath("android.resource://" + packageName + "/" + R.raw.video2)
            var mediaController1 = MediaController(this)
            statusVedio.setMediaController(mediaController1)
            mediaController1.setAnchorView(statusVedio)
            statusVedio.start()
        }, 26000)
    }
}
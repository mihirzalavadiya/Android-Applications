package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var animation : Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animation = AnimationUtils.loadAnimation(this, R.anim.rotate)

        stop.animate().alpha(0F).translationY(40F).setDuration(0).start()

        start.setOnClickListener {
            needle.startAnimation(animation)
            start.animate().alpha(0F).setDuration(1000).start()
            stop.animate().alpha(1F).translationY(-80F).setDuration(1000).start()
            chronometer.setBase(SystemClock.elapsedRealtime())
            chronometer.start()
        }

        stop.setOnClickListener {
            needle.clearAnimation()
            start.animate().alpha(1F).setDuration(1000).start()
            stop.animate().alpha(0F).translationY(40F).setDuration(1000).start()
            chronometer.stop()
        }
    }
}
package com.example.audioapp

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import com.example.audioapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var player: MediaPlayer? = null
    private var oTime = 0
    private var sTime: Int = 0
    private var eTime: Int = 0
    private var fTime: Int = 5000
    private var bTime: Int = 5000
    private val hdlr: Handler = Handler()
    var audioManager: AudioManager? = null

    fun play() {
        if (player == null)
        {
            player = MediaPlayer.create(this, R.raw.rabta)
        }
        player?.start()
    }

    fun pause() {
        player?.pause()
    }

    fun stop() {
        player?.stop()
        player = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        val seekVol = findViewById<SeekBar>(R.id.seekVol)

        val maxVol = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        seekVol.setMax(maxVol);

        val curVol = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
        seekVol.setProgress(curVol)

        seekVol.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.play.setOnClickListener {
            play()
        }

        binding.pause.setOnClickListener {
            pause()
        }

        binding.stop.setOnClickListener {
            stop()
        }
    }
}
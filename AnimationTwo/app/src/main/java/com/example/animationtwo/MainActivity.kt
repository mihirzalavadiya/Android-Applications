package com.example.animationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.animationtwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blinkAnim.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim)
            binding.blinkAnim.startAnimation(animation)
        }

        binding.bounce.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            binding.bounce.startAnimation(animation)
        }

        binding.fadein.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.fadein)
            binding.fadein.startAnimation(animation)
        }

        binding.fadeOut.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.fadeout)
            binding.fadeOut.startAnimation(animation)
        }

        binding.lefttoright.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright)
            binding.lefttoright.startAnimation(animation)
        }

        binding.mixed.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.mixed_anim)
            binding.mixed.startAnimation(animation)
        }

        binding.rigthtoleft.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.righttoleft)
            binding.rigthtoleft.startAnimation(animation)
        }

        binding.rotate.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            binding.rotate.startAnimation(animation)
        }

        binding.sample.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.sample_anim)
            binding.sample.startAnimation(animation)
        }

        binding.zoomin.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.zoomin)
            binding.zoomin.startAnimation(animation)
        }

        binding.zoomout.setOnClickListener {
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.zoomout)
            binding.zoomout.startAnimation(animation)
        }

    }
}
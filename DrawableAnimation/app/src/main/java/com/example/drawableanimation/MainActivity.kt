package com.example.drawableanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.drawableanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var animationDrawable: AnimationDrawable? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.setBackgroundResource(R.drawable.animation)
        animationDrawable = binding.image.background as AnimationDrawable

        binding.image.setOnClickListener {
                animationDrawable?.start()
        }
    }
}
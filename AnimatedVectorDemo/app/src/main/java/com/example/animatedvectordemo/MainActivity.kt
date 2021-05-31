package com.example.animatedvectordemo

import android.annotation.SuppressLint
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animatedvectordemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var flag = true

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnavd.setOnClickListener {
            updateButton()
        }
    }

    private fun updateButton() {
        binding.btnavd.setImageResource(if (flag){
            R.drawable.avd_check_to_close
        }else{
            R.drawable.avd_close_to_check
        })
        val icon = binding.btnavd.drawable
        flag = !flag
        if (icon is AnimatedVectorDrawable) {
            icon.start()
        }
    }
}
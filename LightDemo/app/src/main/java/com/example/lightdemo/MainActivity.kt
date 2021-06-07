package com.example.lightdemo

import android.hardware.Camera
import android.hardware.Camera.Parameters
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lightdemo.databinding.ActivityMainBinding
import java.lang.reflect.Parameter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var camera: Camera? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        camera = Camera.open()
        val parameters: Parameters? = camera?.getParameters()

        binding.switchOff.setOnClickListener {
            binding.switchOff.setVisibility(View.GONE)
            binding.switchOn.setVisibility(View.VISIBLE)
            parameters?.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH)
            camera?.setParameters(parameters)
            camera?.startPreview()
        }

        binding.switchOn.setOnClickListener {
            binding.switchOff.setVisibility(View.VISIBLE)
            binding.switchOn.setVisibility(View.GONE)
            parameters?.setFlashMode(Camera.Parameters.FLASH_MODE_OFF)
            camera?.setParameters(parameters)
            camera?.startPreview()
        }
    }


}
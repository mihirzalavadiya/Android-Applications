package com.example.basicapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicapp.databinding.ActivitySystemAndNavigationBarBinding
import com.google.android.material.internal.ContextUtils.getActivity

class SystemAndNavigationBar : AppCompatActivity() {

    private lateinit var binding : ActivitySystemAndNavigationBarBinding
    val h =null
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySystemAndNavigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hide.setOnClickListener {
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//            actionBar?.hide()
            hideSystemUI()
        }


        binding.show.setOnClickListener {
//            Toast.makeText(this@SystemAndNavigationBar, "You clicked me.", Toast.LENGTH_SHORT).show()
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
//            actionBar?.show()
            showSystemUI()
        }

//        if (Build.VERSION.SDK_INT < 16) {
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        }
//        setContentView(R.layout.activity_system_and_navigation_bar)
    }

    private fun hideSystemUI()
    {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    private fun showSystemUI()
    {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }
}
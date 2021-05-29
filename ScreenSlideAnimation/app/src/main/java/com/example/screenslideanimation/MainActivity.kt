package com.example.screenslideanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var customSwipeAdapter: CustomSwipeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        customSwipeAdapter = CustomSwipeAdapter(this)
        viewPager?.adapter = customSwipeAdapter
    }
}
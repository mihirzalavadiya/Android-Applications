package com.example.dragndrop

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var img: ImageView? = null
    var rootLayout: ViewGroup? = null
    var xdelta = 0
    var ydelta = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.view_root)
        img = rootLayout?.findViewById(R.id.imageView)

        val layoutParams = RelativeLayout.LayoutParams(150, 150)
        img?.layoutParams = layoutParams
        img?.setOnTouchListener(object: View.OnTouchListener {
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                val X = event.rawX.toInt()
                val Y = event.rawY.toInt()
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_DOWN -> {
                        val lParams = view.getLayoutParams() as RelativeLayout.LayoutParams
                        xdelta = X - lParams.leftMargin
                        ydelta = Y - lParams.leftMargin
                    }
                    MotionEvent.ACTION_UP -> { }
                    MotionEvent.ACTION_POINTER_DOWN -> { }
                    MotionEvent.ACTION_POINTER_UP -> { }
                    MotionEvent.ACTION_MOVE -> {
                        val layoutParams = view
                                .getLayoutParams() as RelativeLayout.LayoutParams
                        layoutParams.leftMargin = X - xdelta
                        layoutParams.topMargin = Y - ydelta
                        layoutParams.rightMargin = -250
                        layoutParams.bottomMargin = -250
                        view.setLayoutParams(layoutParams)
                    }
                }
                return true
            }
        })
    }
}
package com.example.crossfadinganimation

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crossfadinganimation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var curruentDrawable = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bitmap0: Bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
        val bitmap1: Bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)

        var canvas = Canvas(bitmap0)
        canvas.drawColor(Color.RED)

        canvas = Canvas(bitmap1)
        canvas.drawColor(Color.GREEN)

        val drawable = arrayOfNulls<BitmapDrawable>(2)
        drawable[0] = BitmapDrawable(resources, bitmap0)
        drawable[1] = BitmapDrawable(resources, bitmap1)

        val crossFader = TransitionDrawable(drawable)
        binding.image.setImageDrawable(crossFader)

        binding.image.setOnClickListener { v ->
//            Toast.makeText(this@MainActivity, "first", Toast.LENGTH_SHORT).show()
            if (curruentDrawable == 0) {
                crossFader.startTransition(500)
                curruentDrawable = 1
            }
            else {
                crossFader.reverseTransition(500)
                curruentDrawable = 0
            }
        }
    }
}
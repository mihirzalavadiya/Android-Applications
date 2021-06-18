package com.example.blurimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var textTitle: TextView? = null
    var image1: ImageView? = null
    var image2:android.widget.ImageView? = null
    var image3:android.widget.ImageView? = null
    var seekbarBlurRadius: SeekBar? = null

    var bitmapOriginal: Bitmap? = null

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTitle = findViewById(R.id.title)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)

        bitmapOriginal = BitmapFactory.decodeResource(resources, R.drawable.farm)

        image1?.setImageBitmap(bitmapOriginal)

        // create blur bitmaps

        // create blur bitmaps
        image2?.setImageBitmap(createBitmap_ScriptIntrinsicBlur(bitmapOriginal, 25.0f))
        image3?.setImageBitmap(createBitmap_ScriptIntrinsicBlur(bitmapOriginal, 25.0f))

        seekbarBlurRadius = findViewById<View>(R.id.blurradius) as SeekBar
        seekbarBlurRadius!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val radius = seekbarBlurRadius!!.progress.toFloat()
                image2?.setImageBitmap(createBitmap_ScriptIntrinsicBlur(bitmapOriginal, radius))
                image3?.setImageBitmap(createBitmap_ScriptIntrinsicBlur(bitmapOriginal, radius))
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun createBitmap_ScriptIntrinsicBlur(src: Bitmap?, r: Float): Bitmap? {

        var radius = r

        if (radius <= 0)
            radius = 0.1f
        else if (radius > 25)
            radius = 25.0f

        val bitmap = Bitmap.createBitmap(src!!.width, src.height, Bitmap.Config.ARGB_8888)

        val renderScript = RenderScript.create(this)

        val blurInput = Allocation.createFromBitmap(renderScript, src)
        val blurOutput = Allocation.createFromBitmap(renderScript, bitmap)

        val blur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
        blur.setInput(blurInput)
        blur.setRadius(radius)
        blur.forEach(blurOutput)

        blurOutput.copyTo(bitmap)
        renderScript.destroy()
        return bitmap

    }
}
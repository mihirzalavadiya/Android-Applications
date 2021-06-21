package com.example.datapassing

import android.graphics.Color
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val rl = findViewById<RelativeLayout>(R.id.your_layout_id)
        val receiveImage = findViewById<ImageView>(R.id.receiveImage)
        val receiveName = findViewById<TextView>(R.id.receiveName)
        val receiveData = findViewById<TextView>(R.id.receiveData)
        val imageValue: Int

        setTitle("People Data")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        var bundle : Bundle? = intent.extras
        var data: String? = bundle?.getString("name")
        receiveName.setText(data)

        data = bundle?.getString("data")
        receiveData.setText(data)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            receiveData.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }

        imageValue = bundle?.getInt("image")!!
        receiveImage.setImageResource(imageValue)

        val colorResourceName: String? = bundle.getString("color")
        rl.setBackgroundColor(Color.parseColor(colorResourceName))
    }
}
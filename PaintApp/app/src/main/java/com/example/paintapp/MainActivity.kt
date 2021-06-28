package com.example.paintapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controllUndo.setOnClickListener {
            PaintArea.setUndo()
        }

        controllRedo.setOnClickListener {
            PaintArea.setRedo()
        }

        controllDelete.setOnClickListener {
            PaintArea.setDelete()
        }

        color_red.setOnClickListener {
            PaintArea.setPaint("red")
        }

        color_blue.setOnClickListener {
            PaintArea.setPaint("blue")
        }

        color_orange.setOnClickListener {
            PaintArea.setPaint("orange")
        }

        color_green.setOnClickListener {
            PaintArea.setPaint("green")
        }

        color_pink.setOnClickListener {
            PaintArea.setPaint("pink")
        }

        color_yellow.setOnClickListener {
            PaintArea.setPaint("yellow")
        }

        color_white.setOnClickListener {
            PaintArea.setPaint("white")
        }
    }
}
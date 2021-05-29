package com.example.menuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater? = getMenuInflater()
        inflater?.inflate(R.menu.example_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.getItemId())
        {
            R.id.item1 -> imageView?.setImageResource(R.drawable.one)
            R.id.item2 -> imageView?.setImageResource(R.drawable.two)
            R.id.item3 -> imageView?.setImageResource(R.drawable.three)
            R.id.subitem1 -> imageView?.setImageResource(R.drawable.one)
            R.id.subitem2 -> imageView?.setImageResource(R.drawable.two)
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}
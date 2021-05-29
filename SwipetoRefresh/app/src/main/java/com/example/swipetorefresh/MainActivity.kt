package com.example.swipetorefresh

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener

class MainActivity : AppCompatActivity() {

    var refreshLayout: SwipeRefreshLayout? = null
    var textView: TextView? = null

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshLayout = findViewById(R.id.refreshLayout)
        textView = findViewById(R.id.textV)

        refreshLayout?.setOnRefreshListener{
                number = number + 1
                textView?.setText(number.toString())
                refreshLayout?.setRefreshing(false)
            }
    }
}
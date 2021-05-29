package com.example.snackebarexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayPopup(view: View) {
        val snakebar: Snackbar? = Snackbar.make(findViewById(R.id.rootLayout), R.string.omessage, Snackbar.LENGTH_LONG);
        snakebar?.show()
    }

    fun displayDialog(view: View) {
        val exampleDialog = ExampleDialog()
        exampleDialog.show(supportFragmentManager, "example dialog")
    }
}
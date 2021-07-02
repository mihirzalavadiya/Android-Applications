package com.example.datepicker

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var c : Calendar? = null
    var dpd: DatePickerDialog? = null


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPick.setOnClickListener {
            c = Calendar.getInstance()
            val day = c?.get(Calendar.DAY_OF_MONTH)
            val month = c?.get(Calendar.MONTH)
            val year = c?.get(Calendar.YEAR)

            dpd = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    txtDate.setText("" + dayOfMonth + "/" +(month+1) + "/" + year)
                }
            }, day!!, month!!, year!!)
            dpd?.show()
        }
    }
}
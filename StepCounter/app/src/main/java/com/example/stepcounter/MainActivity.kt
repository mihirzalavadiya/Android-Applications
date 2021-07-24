package com.example.stepcounter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.CircularPropagation
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    private var sensorManager: SensorManager? = null

    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    lateinit var progress_circular: CircularProgressBar
    lateinit var tv_stepsTaken: TextView
    lateinit var tv_totalMax: TextView

    var currentSteps:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress_circular = findViewById(R.id.cp_progress_circular)
        tv_stepsTaken = findViewById(R.id.tv_stepsTaken)
        tv_totalMax = findViewById(R.id.tv_totalMax)

        loadData()
        resetSteps()
        try{
            sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        }
        catch (e: Exception){
            e.printStackTrace()
//            Toast.makeText(this, "Hello1", Toast.LENGTH_SHORT).show()
        }

        first.setOnClickListener {
            tv_totalMax.setText(first.getText().toString())
        }

        second.setOnClickListener {
            tv_totalMax.setText(second.getText().toString())
        }

        third.setOnClickListener {
            tv_totalMax.setText(third.getText().toString())
        }

        fourth.setOnClickListener {
            tv_totalMax.setText(fourth.getText().toString())
        }

        fifth.setOnClickListener {
            tv_totalMax.setText(fifth.getText().toString())
        }

        sixth.setOnClickListener {
            tv_totalMax.setText(sixth.getText().toString())
        }

    }

    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    override fun onResume() {
        super.onResume()
        running = true
        var stepSensor: Sensor? = null

        try {
            stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        }
        catch (e:Exception) {
            e.printStackTrace()
//            Toast.makeText(this, "Hello2", Toast.LENGTH_SHORT).show()
        }

        if (stepSensor == null)
        {
            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
        }
        else {
            try {
                sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
            }
            catch (e:Exception) {
                e.printStackTrace()
//                Toast.makeText(this, "Hello3", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running) {
            totalSteps = event!!.values[0]
            currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            tv_stepsTaken.text = ("$currentSteps")

            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }

            if (tv_totalMax.text == tv_stepsTaken.text) {
                wish.visibility = View.VISIBLE
                Handler().postDelayed(Runnable {
                    wish.visibility = View.GONE
                }, 3000)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    fun resetSteps()
    {
        tv_stepsTaken.setOnClickListener {
            Toast.makeText(this, "Long tap to reset steps", Toast.LENGTH_SHORT).show()
        }

        tv_stepsTaken.setOnLongClickListener {
            previousTotalSteps = totalSteps
            tv_stepsTaken.text = 0.toString()
            currentSteps = 0
            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
            wish.visibility = View.GONE
            saveData()

            true
        }
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
    }

    private fun loadData()
    {
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber: Float = sharedPreferences.getFloat("key1", 0f)
        Log.d("MainActivity", "$savedNumber")
        previousTotalSteps = savedNumber
        if (tv_totalMax.text == tv_stepsTaken.text) {
            wish.visibility = View.VISIBLE
            Handler().postDelayed(Runnable {
                wish.visibility = View.GONE
            }, 5000)
        }
    }
}
package com.example.datapassing

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstPerson = findViewById<RelativeLayout>(R.id.firstPerson)
        val secondPerson = findViewById<RelativeLayout>(R.id.secondPerson)
        val thirdPerson = findViewById<RelativeLayout>(R.id.thirdPerson)
        val fourthPerson = findViewById<RelativeLayout>(R.id.fourthPerson)
        val fifthPerson = findViewById<RelativeLayout>(R.id.fifthPerson)
        val sixPerson = findViewById<RelativeLayout>(R.id.sixPerson)
        val sevenPerson = findViewById<RelativeLayout>(R.id.sevenPerson)
        val eightPerson = findViewById<RelativeLayout>(R.id.eightPerson)
        val ninePerson = findViewById<RelativeLayout>(R.id.ninePerson)
        val tenPerson = findViewById<RelativeLayout>(R.id.tenPerson)
        val elevenPerson = findViewById<RelativeLayout>(R.id.elevenPerson)
        val twelvePerson = findViewById<RelativeLayout>(R.id.twelvePerson)

        //First Person
        val name1 = findViewById<TextView>(R.id.name1)
        val data1 = findViewById<TextView>(R.id.data1)

        //Second Person
        val name2 = findViewById<TextView>(R.id.name2)
        val data2 = findViewById<TextView>(R.id.data2)

        //Third Person
        val name3 = findViewById<TextView>(R.id.name3)
        val data3 = findViewById<TextView>(R.id.data3)

        //Fourth Person
        val name4 = findViewById<TextView>(R.id.name4)
        val data4 = findViewById<TextView>(R.id.data4)

        //Fifth Person
        val name5 = findViewById<TextView>(R.id.name5)
        val data5 = findViewById<TextView>(R.id.data5)

        //Six Person
        val name6 = findViewById<TextView>(R.id.name6)
        val data6 = findViewById<TextView>(R.id.data6)

        //Seven Person
        val name7 = findViewById<TextView>(R.id.name7)
        val data7 = findViewById<TextView>(R.id.data7)

        //Eight Person
        val name8 = findViewById<TextView>(R.id.name8)
        val data8 = findViewById<TextView>(R.id.data8)

        //Nine Person
        val name9 = findViewById<TextView>(R.id.name9)
        val data9 = findViewById<TextView>(R.id.data9)

        //Ten Person
        val name10 = findViewById<TextView>(R.id.name10)
        val data10 = findViewById<TextView>(R.id.data10)

        //Eleven Person
        val name11 = findViewById<TextView>(R.id.name11)
        val data11 = findViewById<TextView>(R.id.data11)

        //Twelve Person
        val name12 = findViewById<TextView>(R.id.name12)
        val data12 = findViewById<TextView>(R.id.data12)

        firstPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person)
            intent1.putExtra("name", name1.getText().toString())
            intent1.putExtra("data", data1.getText().toString())
            intent1.putExtra("color", "#EC6035")
            startActivity(intent1)
        }

        secondPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person1)
            intent1.putExtra("name", name2.getText().toString())
            intent1.putExtra("data", data2.getText().toString())
            intent1.putExtra("color", "#F1C130")
            startActivity(intent1)
        }

        thirdPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person2)
            intent1.putExtra("name", name3.getText().toString())
            intent1.putExtra("data", data3.getText().toString())
            intent1.putExtra("color", "#5BC3F3")
            startActivity(intent1)
        }

        fourthPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person4)
            intent1.putExtra("name", name4.getText().toString())
            intent1.putExtra("data", data4.getText().toString())
            intent1.putExtra("color", "#E84C81")
            startActivity(intent1)
        }

        fifthPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person5)
            intent1.putExtra("name", name5.getText().toString())
            intent1.putExtra("data", data5.getText().toString())
            intent1.putExtra("color", "#E84C81")
            startActivity(intent1)
        }

        sixPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person6)
            intent1.putExtra("name", name6.getText().toString())
            intent1.putExtra("data", data6.getText().toString())
            intent1.putExtra("color", "#5BC3F3")
            startActivity(intent1)
        }

        sevenPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person7)
            intent1.putExtra("name", name7.getText().toString())
            intent1.putExtra("data", data7.getText().toString())
            intent1.putExtra("color", "#F1C130")
            startActivity(intent1)
        }

        eightPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person8)
            intent1.putExtra("name", name8.getText().toString())
            intent1.putExtra("data", data8.getText().toString())
            intent1.putExtra("color", "#EC6035")
            startActivity(intent1)
        }

        ninePerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person)
            intent1.putExtra("name", name9.getText().toString())
            intent1.putExtra("data", data9.getText().toString())
            intent1.putExtra("color", "#EC6035")
            startActivity(intent1)
        }

        tenPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person1)
            intent1.putExtra("name", name10.getText().toString())
            intent1.putExtra("data", data10.getText().toString())
            intent1.putExtra("color", "#F1C130")
            startActivity(intent1)
        }

        elevenPerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person6)
            intent1.putExtra("name", name11.getText().toString())
            intent1.putExtra("data", data11.getText().toString())
            intent1.putExtra("color", "#5BC3F3")
            startActivity(intent1)
        }

        twelvePerson.setOnClickListener {
            val intent1 = Intent(applicationContext, SecondActivity::class.java)
            intent1.putExtra("image", R.drawable.person6)
            intent1.putExtra("name", name12.getText().toString())
            intent1.putExtra("data", data12.getText().toString())
            intent1.putExtra("color", "#E84C81")
            startActivity(intent1)
        }

    }
}
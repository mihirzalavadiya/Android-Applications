package com.example.guessingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    val max_number = 15
    val random: Random = Random()
    lateinit var guessingNumber:EditText
    lateinit var btnCheckNumber:TextView
    lateinit var low_high: TextView
    lateinit var gameScore: TextView
    lateinit var tryIt: TextView
    var numberToFind: Int = 0
    var numberTries: Int = 0
    var total_try: Int = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guessingNumber = findViewById(R.id.guess_number)
        btnCheckNumber = findViewById(R.id.btn_check)
        low_high = findViewById(R.id.high_low)
        gameScore = findViewById(R.id.game_score)
        tryIt = findViewById(R.id.attempt)

        btnCheckNumber.setOnClickListener {
            var n = Integer.parseInt(guessingNumber.getText().toString())
            numberTries++
//            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
            if (n == numberToFind)
            {
//                Toast.makeText(this, "Hello1", Toast.LENGTH_SHORT).show()
                low_high.setVisibility(View.VISIBLE)
                low_high.setText("Congratulation, You won the game")
                tryIt.setText("You try it : $numberTries")
                total_try = 15 - numberTries
                gameScore.setText("Game Score is : $total_try")

                Handler().postDelayed({
                    newGame()
                },1000)
            }
            else if (n > numberToFind) {
//                Toast.makeText(this, "Hello2", Toast.LENGTH_SHORT).show()
                low_high.setVisibility(View.VISIBLE)
                low_high.setText("Too High")
            } else if (n < numberToFind) {
//                Toast.makeText(this, "Hello3", Toast.LENGTH_SHORT).show()
                low_high.setVisibility(View.VISIBLE)
                low_high.setText(R.string.too_low)
            }
            if(numberTries == 15)
            {
                low_high.setVisibility(View.VISIBLE)
                low_high.setText(R.string.game_over)
            }
//            Toast.makeText(this, "Hello4", Toast.LENGTH_SHORT).show()
        }
    }

    private fun newGame() {
        numberToFind = random.nextInt(max_number) + 1
        guessingNumber.setText("")
        numberTries = 0
        low_high.setVisibility(View.GONE)
        tryIt.setText("You Try it : 0")
    }
}
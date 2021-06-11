package com.example.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var question: TextView
    lateinit var questionNumber: TextView
    lateinit var option1: TextView
    lateinit var option2: TextView
    lateinit var option3: TextView
    lateinit var option4: TextView
    var quizModalArrayList = ArrayList<QuizModal>()
    lateinit var random: Random
    var currentScore: Int = 0
    var questionAttempted: Int = 1
    var currentPos: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        question = findViewById(R.id.question)
        questionNumber = findViewById(R.id.question_attempted)
        option1 = findViewById(R.id.question1_btn)
        option2 = findViewById(R.id.question2_btn)
        option3 = findViewById(R.id.question3_btn)
        option4 = findViewById(R.id.question4_btn)

        quizModalArrayList = ArrayList()
        random = Random()

        getQuizQuestion(quizModalArrayList)
        currentPos = random.nextInt(quizModalArrayList.size)
        setDataToViews(currentPos!!)

        option1.setOnClickListener {
            if (quizModalArrayList.get(currentPos!!).a.trim().toLowerCase().equals(option1.getText().toString().toLowerCase())){
                currentScore++
            }
            questionAttempted++
            currentPos = random.nextInt(quizModalArrayList.size)
            setDataToViews(currentPos!!)
        }

        option2.setOnClickListener {
            if (quizModalArrayList.get(currentPos!!).a.trim().toLowerCase().equals(option2.getText().toString().toLowerCase())){
                currentScore++
            }
            questionAttempted++
            currentPos = random.nextInt(quizModalArrayList.size)
            setDataToViews(currentPos!!)
        }

        option3.setOnClickListener {
            if (quizModalArrayList.get(currentPos!!).a.trim().toLowerCase().equals(option3.getText().toString().toLowerCase())){
                currentScore++
            }
            questionAttempted++
            currentPos = random.nextInt(quizModalArrayList.size)
            setDataToViews(currentPos!!)
        }

        option4.setOnClickListener {
            if (quizModalArrayList.get(currentPos!!).a.trim().toLowerCase().equals(option4.getText().toString().toLowerCase())){
                currentScore++
            }
            questionAttempted++
            currentPos = random.nextInt(quizModalArrayList.size)
            setDataToViews(currentPos!!)
        }

    }

    private fun showBottomSheet() {
        val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView: View = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,findViewById(R.id.idllscore))
        val scoreTV: TextView = bottomSheetView.findViewById(R.id.quiz_score)
        val restart: TextView = bottomSheetView.findViewById(R.id.restart_btn)

        scoreTV.setText("Your Score is \n" + currentScore + "/10")
        restart.setOnClickListener {
            currentPos = random.nextInt(quizModalArrayList.size)
            setDataToViews(currentPos!!)
            questionAttempted = 1
            currentScore = 0
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    private fun setDataToViews(currentPos: Int) {
        questionNumber.setText("Questions Attempted: "+ questionAttempted + "/10")

        if (questionAttempted == 10)
        {
            showBottomSheet()
        }
        else
        {
            question.setText(quizModalArrayList.get(currentPos).q)
            option1.setText(quizModalArrayList.get(currentPos).o1)
            option2.setText(quizModalArrayList.get(currentPos).o2)
            option3.setText(quizModalArrayList.get(currentPos).o3)
            option4.setText(quizModalArrayList.get(currentPos).o4)
        }
    }

    private fun getQuizQuestion(quizModalArrayList: ArrayList<QuizModal>) {
        quizModalArrayList.add(QuizModal("How many days do we have in a week?","Seven", "Five","Two", "None of These", "Seven"))
        quizModalArrayList.add(QuizModal("How many colors are there in a rainbow?","6","2","1","7","7"))
        quizModalArrayList.add(QuizModal("Which animal is known as the Ship of the Desert?","Insects","Camel", "Tottoise","gecko","Camel"))
        quizModalArrayList.add(QuizModal("Which animal is known as the Ship of the Desert?","Insects","Camel", "Tottoise","gecko","Camel"))
        quizModalArrayList.add(QuizModal("How many letters are there in the English alphabet?","15","26", "24","None of these","26"))
        quizModalArrayList.add(QuizModal("Which planet in our solar system is known as the Red Planet?","Jupiter","A and C", "Mars","None of these","Mars"))
        quizModalArrayList.add(QuizModal("What is the name of the biggest planet in our solar system?","Jupiter","A and C", "Mars","None of these","Jupiter"))
        quizModalArrayList.add(QuizModal("Which is the smallest planet in our solar system?","Venus","All of these", "Mars","Mercury","Mercury"))
        quizModalArrayList.add(QuizModal("What is the name of the largest moon of Saturn?","Titan","Uranus", "Mars","Mercury","Titan"))
        quizModalArrayList.add(QuizModal("Who is known as the Iron Man of India?","Dr B. R. Ambedkar","Sardar Vallabhbhai Patel", "A and B","None of these","Sardar Vallabhbhai Patel"))

    }


}
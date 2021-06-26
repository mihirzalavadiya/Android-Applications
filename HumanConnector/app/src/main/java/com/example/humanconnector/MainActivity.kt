package com.example.humanconnector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.humanconnector.databinding.ActivityMainBinding
import com.example.humanconnector.models.PostTypeText
import kotlinx.android.synthetic.main.post_row.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val posts = mutableListOf<PostTypeText>()

        for (i in 1..3){
            posts.add(PostTypeText("Thank you, Margaret, for leaving a review.", "May 10th, 2019"))
        }
        for (i in 1..3){
            posts.add(PostTypeText("The team at Audiology Clinic were happy to meet you earlier this week to discuss your hearing needs.", "May 11th, 2019"))
        }
        for (i in 1..3){
            posts.add(PostTypeText("Your new Bluetooth, iPhone-compatible hearing aids were an excellent selection to make it easier to have conversations over the phone.", "May 12th, 2019"))
        }
        for (i in 1..3){
            posts.add(PostTypeText("We look forward to seeing you again, and bring a friend!", "May 14th, 2019"))
        }

        posts.add(PostTypeText("Thank you very much for sharing your experience with us.", "May 16th, 2019"))

        for(i in 1..5) {
            posts.add(PostTypeText("I did something cool today. Check it out!", "May 10th, 2019"))
        }

        binding.postRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostsAdapter(posts)
        }
    }
}
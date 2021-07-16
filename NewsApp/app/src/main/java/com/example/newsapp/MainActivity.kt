package com.example.newsapp

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapters.ReyclerAdapter
import com.example.newsapp.api.New
import com.example.newsapp.api.NewsApiJSON
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

const val BASE_URL = "https://api.currentsapi.services"

class MainActivity : AppCompatActivity() {

    lateinit var countDownTimer: CountDownTimer

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<String>()
    private var linksList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeAPIRequest()
    }

    private fun setUpRecyclerView() {
        rv_recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        rv_recyclerView.adapter = ReyclerAdapter(titlesList, descList, imagesList, linksList)
    }

    private fun addToList(title: String, description: String, image: String, link: String) {
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
        linksList.add(link)
    }

    private fun makeAPIRequest() {
        val api: APIRequest = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response: NewsApiJSON = api.getNews()

                for (article: New in response.news) {
                    Log.i("MainActivity", "Result = $article")
                    addToList(article.title, article.description, article.image, article.url)
                }

                withContext(Dispatchers.Main) {
                    setUpRecyclerView()
                }
            }
            catch (e : Exception) {
                Log.e("MainActivity", e.toString())
            }
        }
    }
}
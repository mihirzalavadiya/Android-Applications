package com.example.newsapp

import com.example.newsapp.api.NewsApiJSON
import retrofit2.http.GET

interface APIRequest {

    @GET("/v1/latest-news?language=en&apiKey=h7aE_a450Bw4x81vDYNcvoerJVptkGwSTTbfnCMbrpkO-Blq")
    suspend fun getNews() : NewsApiJSON
}
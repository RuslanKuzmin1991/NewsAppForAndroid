package com.example.extendednewsapp.data

import com.example.extendednewsapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("key") key: String = API_KEY): Response<NewsResponse>
}
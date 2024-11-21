package com.example.extendednewsapp.data

import com.example.extendednewsapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNews(countryName: String): Response<NewsResponse>
}
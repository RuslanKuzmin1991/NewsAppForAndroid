package com.example.extendednewsapp.domain

import com.example.extendednewsapp.data.entity.NewsResponse

interface NewsRepository {
    suspend fun getNews(country: String): Result<NewsResponse>
}
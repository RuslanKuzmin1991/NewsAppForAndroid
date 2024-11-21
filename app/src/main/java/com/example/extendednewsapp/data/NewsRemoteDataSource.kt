package com.example.extendednewsapp.data

import com.example.extendednewsapp.data.entity.NewsResponse
import retrofit2.Response

class NewsRemoteDataSource(
    private val apiService: NewsApiService
): NewsDataSource {
    override suspend fun getNews(countryName: String): Response<NewsResponse> {
       return apiService.getNews(countryName)
    }
}
package com.example.extendednewsapp.data

import com.example.extendednewsapp.data.entity.NewsResponse
import com.example.extendednewsapp.domain.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsDataSource: NewsDataSource
) : NewsRepository {
    override suspend fun getNews(country: String): Result<NewsResponse> {
        val result = newsDataSource.getNews(country)
        if (result.isSuccessful) {
            val respone = result.body()
            if (respone != null) {
                return Result.success(respone)
            } else {
                return Result.failure(NewsException.ParsingException("error"))
            }
        } else {
            val exception = handleError(result)
            return Result.failure(exception)
        }
    }

    private fun handleError(response: Response<NewsResponse>): NewsException {
        val code = response.code()
        return when (code) {
            401 -> NewsException.UnauthorizedException("unauth")
            404 -> NewsException.NotFountException("not found")
            500 -> NewsException.NetworkException("server problem")
            else -> NewsException.UnknownException("oops")
        }
    }
}


package com.example.extendednewsapp.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.extendednewsapp.data.NewsException
import com.example.extendednewsapp.data.entity.NewsResponse
import com.example.extendednewsapp.domain.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {
    private val _news = MutableStateFlow(UiNewsState())
    val news: StateFlow<UiNewsState> = _news

    fun getNews(country: String) {
        viewModelScope.launch {
            _news.update {currentValue->
                currentValue.copy(
                    isLoading = true,
                    error = null
                )
            }
            val newsResult = newsRepository.getNews(country)
            if (newsResult.isSuccess) {
                val data = newsResult.getOrNull()
                handleSuccess(data)
            } else {
                val exception = newsResult.exceptionOrNull()
                hadleErrorResponse(exception)
            }
        }
    }

    private fun hadleErrorResponse(exception: Throwable?) {
        var message = "Oops, something wrong"
        if (exception is NewsException) {
            message = exception.message ?: ""
        }
        _news.update {currentValue->
            currentValue.copy(
                error = message,
                isLoading = false
            )
        }
    }

    private fun handleSuccess(response: NewsResponse?) {
        _news.update {currentValue->
            currentValue.copy(
                isLoading = false,
                error = null,
                news = response?.articles ?: emptyList(),
            )
        }
    }
}
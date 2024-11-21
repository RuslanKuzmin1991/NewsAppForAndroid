package com.example.extendednewsapp.presentation.screens

import com.example.extendednewsapp.data.entity.Article

data class UiNewsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val news: List<Article> = emptyList()
)

package com.example.extendednewsapp.di

import com.example.extendednewsapp.data.NewsApiService
import com.example.extendednewsapp.data.NewsDataSource
import com.example.extendednewsapp.data.NewsRemoteDataSource
import com.example.extendednewsapp.data.NewsRepositoryImpl
import com.example.extendednewsapp.domain.NewsRepository
import com.example.extendednewsapp.presentation.screens.NewsViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single<NewsApiService> {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        retrofit.create(NewsApiService::class.java)
    }

    single<NewsDataSource> {
        NewsRemoteDataSource(get())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get())
    }

    viewModel { NewsViewModel(get()) }
}
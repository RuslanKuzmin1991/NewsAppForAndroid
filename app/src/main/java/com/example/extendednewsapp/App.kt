package com.example.extendednewsapp

import android.app.Application
import com.example.extendednewsapp.di.appModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}
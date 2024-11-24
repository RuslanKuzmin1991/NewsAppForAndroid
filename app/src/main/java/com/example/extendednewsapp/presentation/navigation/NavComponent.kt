package com.example.extendednewsapp.presentation.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.extendednewsapp.presentation.screens.CountryScreen
import com.example.extendednewsapp.presentation.screens.NewsScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

@Composable
fun NavComponent(
    modifier: Modifier,
    navController: NavHostController
) {
    Spacer(
        modifier = Modifier.height(100.dp)
    )
    NavHost(navController = navController, startDestination = "Country_screen") {
        composable("Country_screen") { CountryScreen(navController) }
        composable("News_Screen") { NewsScreen(viewModel = koinViewModel()) }
    }
}
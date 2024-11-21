package com.example.extendednewsapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen() {
//    val viewModel: NewsViewModel = koinViewModel()
//    val uiNewsState by viewModel.news.collectAsState()
    val buttonText = remember { mutableStateOf("Button title") }
    Column {
        Text("News Screen")
        Button(
            onClick = { print("")/*viewModel.getNews("us")*/},
            modifier = Modifier.wrapContentSize()
        ) {
            Text(buttonText.value)
        }
    }
}
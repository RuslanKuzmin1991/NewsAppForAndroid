package com.example.extendednewsapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsScreen(viewModel: NewsViewModel) {
    val uiNewsState by viewModel.news.collectAsState(UiNewsState())
    val buttonText = remember { mutableStateOf("Button title") }
    Column {
        Spacer(Modifier.height(100.dp))
        Text("News Screen")
        Button(
            onClick = { viewModel.getNews("us") },
            modifier = Modifier.wrapContentSize()
        ) {
            Text(buttonText.value)
        }
        if (uiNewsState.news.isNotEmpty()) {
            Text(uiNewsState.news.get(0).title,
            modifier = Modifier.wrapContentSize()
            )
        }
    }
}
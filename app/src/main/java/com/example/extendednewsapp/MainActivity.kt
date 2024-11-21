package com.example.extendednewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.extendednewsapp.presentation.navigation.NavComponent
import com.example.extendednewsapp.ui.theme.ExtendedNewsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ExtendedNewsAppTheme {
                Scaffold(
//                    topBar = {
//                        TopAppBar(title = { Text("News app") })
//                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Spacer(
                        modifier = Modifier.height(100.dp)
                    )
                    NavComponent(
                        Modifier.padding(innerPadding),
                        navController
                    )
                }
            }
        }
    }
}
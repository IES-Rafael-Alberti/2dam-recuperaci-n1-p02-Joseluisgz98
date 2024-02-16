package com.example.lacartamasalta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lacartamasalta.CardGames.ui.Principal
import com.example.lacartamasalta.CardGames.ui.ScreenViewModel
import com.example.lacartamasalta.ui.theme.LaCartaMasAltaTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaCartaMasAltaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Principal(viewModel)
                }
            }
        }
    }
}

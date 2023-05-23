package com.mine.gfgnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.mine.gfgnews.ui.navigation.NavGraph
import com.mine.gfgnews.ui.screens.home.HomeViewModel
import com.mine.gfgnews.ui.theme.GFGNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            GFGNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeViewModel : HomeViewModel by viewModels()
                    GFGNewsApp(homeViewModel = homeViewModel)
                }
            }
        }
    }
}

@Composable
fun GFGNewsApp(homeViewModel: HomeViewModel) {
    NavGraph(homeViewModel = homeViewModel)
}

@Preview(showBackground = true)
@Composable
fun GFGNewsAPPPreview() {
    GFGNewsTheme {}
}
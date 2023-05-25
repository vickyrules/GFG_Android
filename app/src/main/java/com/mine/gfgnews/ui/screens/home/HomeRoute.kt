package com.mine.gfgnews.ui.screens.home

import androidx.compose.runtime.Composable

@Composable
fun HomeRoute(homeViewModel: HomeViewModel) {
    HomeScreen(homeViewModel = homeViewModel,
    onRetry = homeViewModel::refresh)
}
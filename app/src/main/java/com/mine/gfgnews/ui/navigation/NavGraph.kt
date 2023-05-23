package com.mine.gfgnews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mine.gfgnews.ui.screens.home.HomeRoute
import com.mine.gfgnews.ui.screens.home.HomeViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route
    ) {
        composable(route = HomeDestination.route) {
            HomeRoute(homeViewModel = homeViewModel)
        }
    }

}
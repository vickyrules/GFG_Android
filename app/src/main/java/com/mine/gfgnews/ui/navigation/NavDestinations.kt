package com.mine.gfgnews.ui.navigation

import com.mine.gfgnews.R

interface NavDestinations {
    val title : Int
    val route : String
}


internal object HomeDestination : NavDestinations{
    override val title: Int = R.string.app_name
    override val route: String = "home"
}

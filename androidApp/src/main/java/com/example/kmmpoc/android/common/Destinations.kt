package com.example.kmmpoc.android.common

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destinations {
    val title: String
    val route: String
    val routeWithArgs: String
}


object Home : Destinations {
    override val title: String
        get() = "Birds"

    override val route: String
        get() = "home"

    override val routeWithArgs: String
        get() = route
}


object Detail : Destinations {
    override val title: String
        get() = "Bird Detail"

    override val route: String
        get() = "detail"

    override val routeWithArgs: String
        get() = "$route/{movieId}"

    val arguments = listOf(
        navArgument(name = "movieId") { type = NavType.IntType },
//        navArgument(name = "movieUrl") { type = NavType.StringType },
//        navArgument(name = "movieTitle") { type = NavType.StringType },
//        navArgument(name = "movieDescription") { type = NavType.StringType }
    )
}

val coinDetinations = listOf(Home, Detail)
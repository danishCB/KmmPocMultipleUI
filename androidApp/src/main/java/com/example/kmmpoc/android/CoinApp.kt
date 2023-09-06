package com.example.kmmpoc.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kmmpoc.android.common.CoinAppBar
import com.example.kmmpoc.android.common.Detail
import com.example.kmmpoc.android.common.Home
import com.example.kmmpoc.android.common.coinDetinations
import com.example.kmmpoc.android.home.Detail.DetailScreen
import com.example.kmmpoc.android.home.Detail.DetailViewModel
import com.example.kmmpoc.android.home.HomeScreen
import com.example.kmmpoc.android.home.HomeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun CoinApp() {

    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    val isSystemDarkMode = isSystemInDarkTheme()

    val statusBarColor = if (isSystemDarkMode) {
        MaterialTheme.colors.primaryVariant
    } else {
        Color.Transparent
    }

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor, darkIcons = !isSystemDarkMode)
    }

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = coinDetinations.find {
        backStackEntry?.destination?.route == it.route || backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CoinAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen
            ) {
                navController.navigateUp()
            }
        }
    ) { innerpadding ->

        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerpadding),
            startDestination = Home.routeWithArgs
        ) {
            composable(Home.routeWithArgs) {

                HomeScreen(pullToRefresh = { false }, navigateToDetail = {
                    navController.navigate(
                        "${Detail.route}/${it.id}"
                    )
                })

            }

            composable(Detail.routeWithArgs, arguments = Detail.arguments) {
                val coinId = it.arguments?.getInt("movieId") ?: 0

                DetailScreen(
                    modifier = Modifier,
                    coinId = coinId
                )
            }
        }

    }

}
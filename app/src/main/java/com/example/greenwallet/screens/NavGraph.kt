package com.example.greenwallet.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreensRoutes.SplashScreen.route
        ){
        composable(
            route = ScreensRoutes.SplashScreen.route
        ) {
            SplashScreenNav(navController)
        }
        composable(
            route = ScreensRoutes.GetStartedScreen.route
        ) {
            GetStarted()
        }
    }
}
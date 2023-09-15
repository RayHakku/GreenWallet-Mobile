package com.example.greenwallet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.greenwallet.ui.screens.GetStarted
import com.example.greenwallet.ui.screens.LoginScreen
import com.example.greenwallet.ui.screens.RegisterScreen
import com.example.greenwallet.ui.screens.RegisterSuccess
import com.example.greenwallet.ui.screens.SplashScreenNav

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
            GetStarted(navController = navController)
        }
        composable(
            route = ScreensRoutes.RegisterScreen.route
        ) {
            RegisterScreen(navController)
        }
        composable(
            route = ScreensRoutes.RegisterSuccessScreen.route
        ) {
            RegisterSuccess(navController)
        }
        composable(
            route = ScreensRoutes.LoginScreen.route
        ) {
            LoginScreen(navController)
        }
    }
}


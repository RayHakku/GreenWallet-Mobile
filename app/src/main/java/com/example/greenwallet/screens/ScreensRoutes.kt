package com.example.greenwallet.screens

sealed class ScreensRoutes(val route: String){
    object SplashScreen: ScreensRoutes(route = "splash_screen")
    object GetStartedScreen: ScreensRoutes(route = "get_started_screen")
}

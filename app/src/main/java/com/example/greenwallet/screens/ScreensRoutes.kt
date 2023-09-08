package com.example.greenwallet.screens

sealed class ScreensRoutes(val route: String){
    object SplashScreen: ScreensRoutes(route = "splash_screen")
    object GetStartedScreen: ScreensRoutes(route = "get_started_screen")
    object RegisterScreen: ScreensRoutes(route = "register_screen")
    object RegisterSuccessScreen: ScreensRoutes(route = "register_success_screen")
    object LoginScreen: ScreensRoutes(route = "login_screen")
}
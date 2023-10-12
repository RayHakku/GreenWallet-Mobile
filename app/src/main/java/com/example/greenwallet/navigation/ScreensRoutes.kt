package com.example.greenwallet.navigation

sealed class ScreensRoutes(val route: String){
    object SplashScreen: ScreensRoutes(route = "splash_screen")
    object GetStartedScreen: ScreensRoutes(route = "get_started_screen")
    object RegisterScreen: ScreensRoutes(route = "register_screen")
    object RegisterSuccessScreen: ScreensRoutes(route = "register_success_screen")
    object LoginScreen: ScreensRoutes(route = "login_screen")
    object HomeScreen: ScreensRoutes(route = "home_screen/{userId}")
    object InfoScreen: ScreensRoutes(route = "info_screen/{userId}")
}



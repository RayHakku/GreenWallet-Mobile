package com.example.greenwallet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.greenwallet.R
import com.example.greenwallet.navigation.ScreensRoutes
import kotlinx.coroutines.delay


@Composable
fun SplashScreenNav(navController: NavController) {
    LaunchedEffect(key1 = true ){
        delay(2500)
        navController.popBackStack()
        navController.navigate(ScreensRoutes.GetStartedScreen.route)
    }

    SplashScreen()
}
@Composable
fun SplashScreen
            (

) {

    Row (

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsl(104F, 0.61F, 0.66F, 1F)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ri_money_pound_circle_fill),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 40.dp)
        )
        Text(
            text = "Green Wallet",
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Left,
            lineHeight = 50.sp
        )

    }
}

@Preview
@Composable
fun SplashScreenPrev() {
    //SplashScreen()
}
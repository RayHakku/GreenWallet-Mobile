package com.example.greenwallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.navigation.ScreensRoutes

@Composable
fun RegisterSuccess(
    navController: NavController
) {
    fun navigateToLogin() {
        navController.popBackStack()
        navController.navigate(ScreensRoutes.LoginScreen.route)
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsl(104F, 1F, 0.9F, 1f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.winners_cuate),
            contentDescription = "Two persons lifting a trophy",
            modifier = Modifier
                .padding(vertical = 40.dp)
        )
        Text(
            text = "Sucesso!",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 20.dp)
        )
        Text(
            text ="Você foi cadastrado!",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(bottom = 35.dp)
        )
        Button(
            onClick = {
                navigateToLogin()
                      },
            shape = MaterialTheme.shapes.small,
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                contentColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
        ) {
            Text(
                text = "Concluir",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun RegisterSuccessPrev() {
    RegisterSuccess(rememberNavController())
}
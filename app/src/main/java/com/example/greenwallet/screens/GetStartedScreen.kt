package com.example.greenwallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.navigation.ScreensRoutes


@Composable
fun GetStarted(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.hsl(104F, 1F, 0.9F, 1f))
            .padding(20.dp),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.wallet_cuate2),
            contentDescription = "Woman with a wallet",
            modifier = Modifier
                .padding(vertical = 40.dp)
        )
        Surface(
            modifier = Modifier
                .padding(vertical = 50.dp)
                //.fillMaxHeight(0.35f)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
        )
        {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                Text(
                    text = "Comece Agora",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    lineHeight = 5.sp,
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 10.dp , top = 15.dp),
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.hsl(0F, 0F,0F,0.3f),
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .fillMaxWidth(0.8f),


                    )
                Button(
                    onClick = {
                        navController.navigate(ScreensRoutes.RegisterScreen.route)
                    },
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(bottom = 5.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                        contentColor = Color.White,
                    ),
                    border = androidx.compose.material3.ButtonDefaults.outlinedButtonBorder

                ) {
                    Text(
                        text = "Criar Conta",
                        fontWeight = FontWeight.Bold,
                    )
                }
                Button(
                    onClick = {
                        navController.navigate(ScreensRoutes.LoginScreen.route)
                              },
                    shape = MaterialTheme.shapes.small,
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(104F, 0.62F, 0.51F, 0.1f),
                        contentColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(top = 10.dp, bottom = 30.dp),
                    border = androidx.compose.material3.ButtonDefaults.outlinedButtonBorder

                ) {
                    Text(
                        text = "Entrar",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun GetStartedPrev() {
    GetStarted(navController = rememberNavController())
}
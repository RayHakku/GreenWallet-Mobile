package com.example.greenwallet.ui.screens

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
import androidx.compose.ui.res.stringResource
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
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.wallet_cuate2),
            contentDescription = stringResource(R.string.woman_with_a_wallet_getStarted),
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
        )
        {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                Text(
                    text = stringResource(R.string.start_now_getStarted),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    lineHeight = 5.sp,
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = stringResource(R.string.lorem_Ipsum_GetStarted),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.hsl(0F, 0F,0F,0.3f),
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),


                    )
                Button(
                    onClick = {
                        navController.navigate(ScreensRoutes.RegisterScreen.route)
                    },
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        ,
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                        contentColor = Color.White,
                    ),
                    border = androidx.compose.material3.ButtonDefaults.outlinedButtonBorder

                ) {
                    Text(
                        text = stringResource(R.string.create_account_button_getStarted),
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
                        .fillMaxWidth(0.6f),
                    border = androidx.compose.material3.ButtonDefaults.outlinedButtonBorder

                ) {
                    Text(
                        text = stringResource(R.string.login_button_getStarted),
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
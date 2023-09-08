package com.example.greenwallet.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.navigation.ScreensRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController
) {
    fun navigateBack() {
        navController.navigate(ScreensRoutes.GetStartedScreen.route)
    }
    var lembrarlogin by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsl(104F, 1F, 0.9F, 1f))
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(painter = painterResource(
            id = R.drawable.baseline_arrow_back_ios_24),
            contentDescription = "Arrow Back",
            modifier = Modifier
                .padding(top = 15.dp)
                .clickable {
                    navigateBack()
                }
        )
        Text(
            text = "Login",
            textAlign = TextAlign.Left,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Text(
            text = "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            shape = MaterialTheme.shapes.medium,
            singleLine = true,
            placeholder = {
                Text(
                    text = "Insira seu email"
                )
                          },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(bottom = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                )
        )
        Text(
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            shape = MaterialTheme.shapes.medium,
            singleLine = true,
            placeholder = {
                Text(
                    text = "Insira sua senha"
                )
                          },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(bottom = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                )
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = lembrarlogin ,
                onCheckedChange = { lembrarlogin = it}
            )
            Text(
                text = "Lembrar conta",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(
                modifier = Modifier
                    .width(84.dp)
            )
            Text(
                text = "Esqueci minha senha",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.hsl(0F, 0F, 0F, 0.5f),
            )
        }
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                          /*TODO*/
                          },
                shape = MaterialTheme.shapes.extraLarge,
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(90.dp)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(rememberNavController())
}
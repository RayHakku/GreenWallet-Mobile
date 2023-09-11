package com.example.greenwallet.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.components.MainButtonMedium
import com.example.greenwallet.components.MainTextFieldComponent
import com.example.greenwallet.components.PasswordTextField
import com.example.greenwallet.components.SecondaryButtonMedium
import com.example.greenwallet.data.RegisterViewModel
import com.example.greenwallet.data.UIEvent
import com.example.greenwallet.navigation.ScreensRoutes


@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel(),
) {

    var userTerms by remember { mutableStateOf(false) }


    fun navigateToRegisterSuccess() {
        navController.popBackStack()
        navController.navigate(ScreensRoutes.RegisterSuccessScreen.route)
    }

    fun navigateToLogin() {
        navController.popBackStack()
        navController.navigate(ScreensRoutes.LoginScreen.route)
    }

    fun navigateBack() {
        navController.navigate(ScreensRoutes.GetStartedScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsl(104F, 1F, 0.9F, 1f)),
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .clickable {
                        navigateBack()
                    }
            )
            Text(
                text = "Crie sua conta",
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet.",
                fontSize = 14.sp,
                color = Color.hsl(0F, 0F, 0F, 0.45f),
                modifier = Modifier
                    .padding(top = 5.dp, start = 20.dp, bottom = 15.dp)
            )
            Text(
                text = "Primeiro Nome",
                modifier = Modifier
                    .padding(start = 5.dp, top = 15.dp, bottom = 2.dp)
            )
            MainTextFieldComponent(
                placeholderValue = "Digite seu primeiro nome", onTextSelected = {
                    registerViewModel.onEvent(UIEvent.FirtsNameChange(it))
                }
            )
            Text(
                text = "Sobrenome",
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 2.dp)
            )
            MainTextFieldComponent(
                placeholderValue = "Digite seu sobrenome", onTextSelected = {
                    registerViewModel.onEvent(UIEvent.LastNameChange(it))
                }
            )
            Text(
                text = "CPF",
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 2.dp)
            )
            MainTextFieldComponent(
                placeholderValue = "Digite seu CPF",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.CpfChange(it.toInt()))
                })
            Text(
                text = "Email",
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 2.dp)
            )
            MainTextFieldComponent(
                placeholderValue = "Digite seu email",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.EmailChange(it))
                })
            Text(
                text = "Senha",
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 2.dp)
            )
            PasswordTextField(
                placeholderValue = "Digite sua senha",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.PasswordChange(it))
                }
            )
            Text(
                text = "Confirme a Senha",
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 2.dp)
            )
            PasswordTextField(
                placeholderValue = "Confirme sua senha",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.ConfirmPasswordChange(it))
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = userTerms,
                    onCheckedChange = { userTerms = it },
                )
                Text(
                    text = "Eu aceito os termos de uso"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                MainButtonMedium(
                    value = "Criar conta",
                    onClick = {
                    registerViewModel.onEvent(UIEvent.RegisterButtonClick)
                    navigateToRegisterSuccess()
                    }
                )
                Text(
                    text = "Ja possui uma conta?"
                )
                SecondaryButtonMedium(
                    value = "Entrar",
                    onClick = {
                    navigateToLogin()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPrev() {
    RegisterScreen(rememberNavController())
}
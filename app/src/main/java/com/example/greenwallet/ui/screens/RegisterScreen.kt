package com.example.greenwallet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.ui.CPFTextFieldComponent
import com.example.greenwallet.ui.CheckBoxMainComponent
import com.example.greenwallet.ui.MainButtonMedium
import com.example.greenwallet.ui.MainTextFieldComponent
import com.example.greenwallet.ui.PasswordTextField
import com.example.greenwallet.ui.SecondaryButtonMedium
import com.example.greenwallet.data.viewmodels.RegisterViewModel
import com.example.greenwallet.data.UIEvent
import com.example.greenwallet.data.classes.ViewModelFactory
import com.example.greenwallet.navigation.ScreensRoutes


@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel(
        factory = ViewModelFactory(navController, null)
    ),
) {

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
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Arrow Back",
                modifier = Modifier
                    //.padding(start = 15.dp)
                    .clickable {
                        navigateBack()
                    }
            )
            Text(
                text = "Crie sua conta",
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp, start = 15.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet.",
                fontSize = 14.sp,
                color = Color.hsl(0F, 0F, 0F, 0.45f),
                modifier = Modifier
                    .padding(top = 5.dp, start = 20.dp, bottom = 5.dp)
            )

            MainTextFieldComponent(
                placeholderValue = "Digite seu primeiro nome",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.FirstsNameChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.firstNameError,
                errorMessage = registerViewModel.registerState.value.firstNameErrorMessage,
                labelValue = "Primeiro Nome"
            )

            MainTextFieldComponent(
                placeholderValue = "Digite seu sobrenome",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.LastNameChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.lastNameError,
                errorMessage = registerViewModel.registerState.value.lastNameErrorMessage,
                labelValue = "Sobrenome"
            )
            CPFTextFieldComponent(
                placeholderValue = "Digite seu CPF",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.CpfChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.cpfError,
                errorMessage = registerViewModel.registerState.value.cpfErrorMessage,
                labelValue = "CPF"
            )

            MainTextFieldComponent(
                placeholderValue = "Digite seu email",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.EmailChange(it))
                },
                errorStatus = registerViewModel.registerState.value.emailError,
                errorMessage = registerViewModel.registerState.value.emailErrorMessage,
                labelValue = "Email"
            )
            PasswordTextField(
                placeholderValue = "Digite sua senha",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.PasswordChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.passwordError,
                errorMessage = registerViewModel.registerState.value.passwordErrorMessage,
                labelValue = "Senha"
            )
            PasswordTextField(
                placeholderValue = "Confirme sua senha",
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.ConfirmPasswordChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.confirmPasswordError,
                errorMessage = registerViewModel.registerState.value.confirmPasswordErrorMessage,
                labelValue = "Confirme a Senha"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                CheckBoxMainComponent(
                    onCheckedChange = {
                        registerViewModel.onEvent(UIEvent.UserTermsChange(it))
                    }
                )
                Text(
                    text = "Eu aceito os termos de uso"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                        ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                MainButtonMedium(
                    value = "Criar conta",
                    onClick = {
                    registerViewModel.onEvent(UIEvent.RegisterButtonClick)
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
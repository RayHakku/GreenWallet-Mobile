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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = stringResource(R.string.arrow_back),
                modifier = Modifier
                    .clickable {
                        navigateBack()
                    }
            )
            Text(
                text = stringResource(R.string.create_an_account),
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp, start = 15.dp)
            )
            Text(
                text = stringResource(R.string.lorem_ipsum_registerScreen),
                fontSize = 14.sp,
                color = Color.hsl(0F, 0F, 0F, 0.45f),
                modifier = Modifier
                    .padding(top = 5.dp, start = 20.dp, bottom = 5.dp)
            )

            MainTextFieldComponent(
                placeholderValue = stringResource(R.string.enter_your_first_name),
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.FirstsNameChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.firstNameError,
                errorMessage = registerViewModel.registerState.value.firstNameErrorMessage,
                labelValue = stringResource(R.string.first_name)
            )

            MainTextFieldComponent(
                placeholderValue = stringResource(R.string.enter_your_surname),
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.LastNameChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.lastNameError,
                errorMessage = registerViewModel.registerState.value.lastNameErrorMessage,
                labelValue = stringResource(R.string.surname_label)
            )
            CPFTextFieldComponent(
                placeholderValue = stringResource(R.string.enter_your_social_security_number),
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.CpfChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.cpfError,
                errorMessage = registerViewModel.registerState.value.cpfErrorMessage,
                labelValue = stringResource(R.string.social_security_number_label)
            )

            MainTextFieldComponent(
                placeholderValue = stringResource(R.string.enter_your_email),
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.EmailChange(it))
                },
                errorStatus = registerViewModel.registerState.value.emailError,
                errorMessage = registerViewModel.registerState.value.emailErrorMessage,
                labelValue = stringResource(R.string.email_label)
            )
            PasswordTextField(
                placeholderValue = stringResource(R.string.enter_your_password),
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.PasswordChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.passwordError,
                errorMessage = registerViewModel.registerState.value.passwordErrorMessage,
                labelValue = stringResource(R.string.password_label)
            )
            PasswordTextField(
                placeholderValue = stringResource(R.string.confirm_your_password),
                onTextSelected = {
                    registerViewModel.onEvent(UIEvent.ConfirmPasswordChange(it)
                    )
                },
                errorStatus = registerViewModel.registerState.value.confirmPasswordError,
                errorMessage = registerViewModel.registerState.value.confirmPasswordErrorMessage,
                labelValue = stringResource(R.string.confirm_password_label)
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
                    text = stringResource(R.string.i_agree_to_the_terms_of_use)
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
                    value = stringResource(id = R.string.create_account_button_getStarted),
                    onClick = {
                    registerViewModel.onEvent(UIEvent.RegisterButtonClick)
                    }
                )
                Text(
                    text = stringResource(R.string.already_have_an_account)
                )
                SecondaryButtonMedium(
                    value = stringResource(id = R.string.login_button_getStarted),
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
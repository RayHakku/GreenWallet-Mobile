package com.example.greenwallet.ui.screens

import android.widget.Toast
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.data.Biometry
import com.example.greenwallet.data.classes.SharedPreferencesProvider
import com.example.greenwallet.data.classes.ViewModelFactory
import com.example.greenwallet.data.states.LoginState
import com.example.greenwallet.data.viewmodels.LoginViewModel
import com.example.greenwallet.navigation.ScreensRoutes
import com.example.greenwallet.ui.MainTextFieldComponent
import com.example.greenwallet.ui.PasswordTextField
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(
    navController: NavController,
    sharedPreferencesProvider: SharedPreferencesProvider,
    loginViewModel: LoginViewModel = viewModel(
        factory = ViewModelFactory(navController, sharedPreferencesProvider)
    ),
) {

    val auth =  FirebaseAuth.getInstance()
    fun navigateBack() {
        navController.navigate(ScreensRoutes.GetStartedScreen.route)
    }
    val context = LocalContext.current
    val checkedRememberMe = remember {
        loginViewModel.rememberMe()
    }

    val bioTitle = stringResource(id = R.string.login_button_getStarted)
    val bioSubtitle = stringResource(R.string.log_in_with_your_biometrics)
    val bioCancel = stringResource(R.string.cancel)
    val bioDescription = stringResource(R.string.touch_the_biometric_sensor_to_log_in)

    LaunchedEffect(true){
        if (checkedRememberMe) {
            println(auth.currentUser)
            Biometry.authenticateBio(
                activity = context as FragmentActivity,
                title = bioTitle,
                subtitle = bioSubtitle,
                description = bioDescription,
                negativeText = bioCancel,
                onSuccess = {
                    loginViewModel.autoLogin()
                },
                onCancel = {
                    loginViewModel.canceledBioLogin()
                },
                onError = {
                        _, errorString ->

                    Toast.makeText(context, errorString, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

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
            contentDescription = stringResource(id = R.string.arrow_back),
            modifier = Modifier
                .padding(top = 15.dp)
                .clickable {
                    navigateBack()
                }
        )
        Text(
            text = stringResource(id = R.string.login_button_getStarted),
            textAlign = TextAlign.Left,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Text(
            text = stringResource(id = R.string.email_label),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        )
        MainTextFieldComponent(
            placeholderValue = stringResource(id = R.string.enter_your_email),
            onTextSelected = {
                loginViewModel.onEvent(
                    LoginState.EmailChange(it)
                )
            },
            errorStatus = loginViewModel.loginDataState.value.emailLoginError,
            errorMessage = loginViewModel.loginDataState.value.emailLoginErrorMessage,
            labelValue = stringResource(id = R.string.email_label),
        )

        Text(
            text = stringResource(id = R.string.password_label),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
        )

        PasswordTextField(
            placeholderValue = stringResource(id = R.string.enter_your_password),
            onTextSelected = {
                loginViewModel.onEvent(
                    LoginState.PasswordChange(it)
                )
            },
            errorStatus = loginViewModel.loginDataState.value.passwordLoginError,
            errorMessage = loginViewModel.loginDataState.value.passwordLoginErrorMessage,
            labelValue = stringResource(id = R.string.password_label)
        )

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = loginViewModel.loginDataState.value.rememberMe,
                onCheckedChange = {
                     loginViewModel.onEvent(
                        LoginState.RememberMeChange(it)
                    )
                }
            )
            Text(
                text = stringResource(R.string.remember_me),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(
                modifier = Modifier
                    .width(84.dp)
            )
            Text(
                text = stringResource(R.string.forgot_my_password),
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

            Text(
                text = loginViewModel.loginDataState.value.loginInvalidMessage,
            )

            Button(
                onClick = {
                    loginViewModel.onEvent(
                        LoginState.LoginButtonClick
                    )
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
                    text = stringResource(id = R.string.login_button_getStarted),
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(rememberNavController(), SharedPreferencesProvider(LocalContext.current))
}
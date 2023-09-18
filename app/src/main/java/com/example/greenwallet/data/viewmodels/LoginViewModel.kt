package com.example.greenwallet.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.greenwallet.data.states.LoginDataState
import com.example.greenwallet.data.states.LoginState
import com.example.greenwallet.data.validation.Validator
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel (
   private val navController: NavController
) : ViewModel()
 {
    private val auth = FirebaseAuth.getInstance()
    private val loginState = MutableLiveData<LoginState>()
    val loginDataState = mutableStateOf(LoginDataState())

    fun onEvent(event: LoginState){
        when (event){
            is LoginState.EmailChange -> {
                loginDataState.value = loginDataState.value.copy(
                    email = event.email
                )
                validateEmail()
            }
            is LoginState.LoginError -> {
                loginState.value = LoginState.LoginError(
                    event.message
                )
            }
            is LoginState.LoginSuccess -> {
                loginState.value = LoginState.LoginSuccess(
                    event.userId
                )
            }
            is LoginState.PasswordChange -> {
                loginDataState.value = loginDataState.value.copy(
                    password = event.password
                )
                validatePassword()
            }
            LoginState.LoginButtonClick -> {
                login(
                    loginDataState.value.email,
                    loginDataState.value.password
                )

            }

            is LoginState.RememberMeChange -> {
                loginDataState.value = loginDataState.value.copy(
                    rememberMe = event.rememberMe
                )
            }
        }
    }

    private fun login(email: String, password: String) {
        if (validateLogin()) {
            singIn(email, password)
        }
    }

    private fun singIn(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    val userId = auth.currentUser?.uid.toString()

                    if (loginDataState.value.rememberMe){
                        TODO()
                    }
                    navController.navigate("home_screen/$userId")

                }
            }
            .addOnFailureListener{



            }
    }
     private fun validateEmail(): Boolean{
         val emailRes = Validator.validateEmail(
             loginDataState.value.email
         )
            loginDataState.value = loginDataState.value.copy(
                emailLoginError = emailRes.isValid,
                emailLoginErrorMessage = emailRes.message
            )
         return emailRes.isValid
     }

     private fun validatePassword(): Boolean{
         val passwordRes = Validator.validatePassword(
             loginDataState.value.password
         )
         loginDataState.value = loginDataState.value.copy(
             passwordLoginError = passwordRes.isValid,
             passwordLoginErrorMessage = passwordRes.message
         )
         return passwordRes.isValid
     }

     private fun validateLogin(): Boolean{
            return validateEmail() && validatePassword()
        }
}
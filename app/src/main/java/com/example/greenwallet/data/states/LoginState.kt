package com.example.greenwallet.data.states

sealed class LoginState{
    // Data states
    data class LoginSuccess(val userId: String?): LoginState()
    data class LoginError(val message: String?): LoginState()


    // Data Changes
    data class EmailChange(val email: String): LoginState()
    data class PasswordChange(val password: String): LoginState()
    data class RememberMeChange(val rememberMe: Boolean): LoginState()
    object LoginButtonClick: LoginState()

}

data class LoginDataState(
    // Data states
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,

    // Error states
    var emailLoginError: Boolean = true,
    var emailLoginErrorMessage: String = "",
    val passwordLoginError: Boolean = true,
    val passwordLoginErrorMessage: String = "",
    var loginInvalidMessage: String = "",
    )
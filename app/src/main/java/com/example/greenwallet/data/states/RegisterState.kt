package com.example.greenwallet.data.states

data class RegisterState (
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val cpf: String = "",

    val firstNameError: Boolean = true,
    val lastNameError: Boolean = true,
    val emailError: Boolean = true,
    val passwordError: Boolean = true,
    val confirmPasswordError: Boolean = true,
    val cpfError: Boolean = true,
    val userTermsError: Boolean = true,

    val firstNameErrorMessage: String = "",
    val lastNameErrorMessage: String = "",
    val emailErrorMessage: String = "",
    val passwordErrorMessage: String = "",
    val confirmPasswordErrorMessage: String = "",
    val cpfErrorMessage: String = "",
    val userTermsErrorMessage: String = "",

)


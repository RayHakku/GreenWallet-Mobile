package com.example.greenwallet.data

data class RegisterState (
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val cpf: String = "",
    val userTerms: Boolean = false,

    val firstNameError: Boolean = true,
    val lastNameError: Boolean = true,
    val emailError: Boolean = true,
    val passwordError: Boolean = true,
    val confirmPasswordError: Boolean = true,
    val cpfError: Boolean = true,

    val firstNameErrorMessage: String = "",
    val lastNameErrorMessage: String = "",
    val emailErrorMessage: String = "",
    val passwordErrorMessage: String = "",
    val confirmPasswordErrorMessage: String = "",
    val cpfErrorMessage: String = "",

)

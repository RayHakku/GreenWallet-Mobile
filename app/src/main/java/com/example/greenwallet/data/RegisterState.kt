package com.example.greenwallet.data

data class RegisterState (
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val cpf: Int = 0,
    val userTerms: Boolean = false,
)

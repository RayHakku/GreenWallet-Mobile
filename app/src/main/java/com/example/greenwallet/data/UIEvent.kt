package com.example.greenwallet.data

sealed class UIEvent{

    data class FirstsNameChange(val firstName: String): UIEvent()
    data class LastNameChange(val lastName: String): UIEvent()
    data class EmailChange(val email: String): UIEvent()
    data class PasswordChange(val password: String): UIEvent()
    data class ConfirmPasswordChange(val confirmPassword: String): UIEvent()
    data class CpfChange(val cpf: String): UIEvent()
    data class UserTermsChange(val userTerms: Boolean): UIEvent()
    object RegisterButtonClick: UIEvent()
}

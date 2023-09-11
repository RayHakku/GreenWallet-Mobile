package com.example.greenwallet.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    private var registerState = mutableStateOf(RegisterState())

    fun onEvent (event: UIEvent){
        when(event){
            is UIEvent.FirtsNameChange -> {
                registerState.value = registerState.value.copy(
                    firstName = event.firstName
                )
            }
            is UIEvent.LastNameChange -> {
                registerState.value = registerState.value.copy(
                    lastName = event.lastName
                )
            }
            is UIEvent.EmailChange -> {
                registerState.value = registerState.value.copy(
                    email = event.email
                )
            }
            is UIEvent.PasswordChange -> {
                registerState.value = registerState.value.copy(
                    password = event.password
                )
            }
            is UIEvent.ConfirmPasswordChange -> {
                registerState.value = registerState.value.copy(
                    confirmPassword = event.confirmPassword
                )
            }
            is UIEvent.CpfChange -> {
                registerState.value = registerState.value.copy(
                    cpf = event.cpf
                )
            }
            is UIEvent.UserTermsChange -> {
                registerState.value = registerState.value.copy(
                    userTerms = event.userTerms
                )
            }
            is UIEvent.RegisterButtonClick -> {
                register()
            }
        }
    }

    private fun register() {
        TODO("Not yet implemented")
    }
}

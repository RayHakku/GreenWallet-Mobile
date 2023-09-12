package com.example.greenwallet.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.greenwallet.data.validation.Validator

class RegisterViewModel : ViewModel() {
    internal var registerState = mutableStateOf(RegisterState())

    fun onEvent (event: UIEvent){
        validateData()
        when(event){
            is UIEvent.FirstsNameChange -> {
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
        validateData()
    }

    private fun validateData(): Boolean {
        val firstNameRes = Validator.validateFirstName(
            firstName = registerState.value.firstName
        )
        val lastNameRes = Validator.validateLastName(
            lastName = registerState.value.lastName
        )
        val emailRes = Validator.validateEmail(
            email = registerState.value.email
        )
        val passwordRes = Validator.validatePassword(
            password = registerState.value.password
        )
        val confirmPasswordRes = Validator.validateConfirmPassword(
            password = registerState.value.password,
            confirmPassword = registerState.value.confirmPassword
        )
        val cpfRes = Validator.validateCPF(
            cpf = registerState.value.cpf
        )

        registerState.value = registerState.value.copy(
            firstNameError = firstNameRes.isValid,
            lastNameError = lastNameRes.isValid,
            emailError = emailRes.isValid,
            passwordError = passwordRes.isValid,
            confirmPasswordError = confirmPasswordRes.isValid,
            cpfError = cpfRes.isValid,
            firstNameErrorMessage = firstNameRes.message,
            lastNameErrorMessage = lastNameRes.message,
            emailErrorMessage = emailRes.message,
            passwordErrorMessage = passwordRes.message,
            confirmPasswordErrorMessage = confirmPasswordRes.message,
            cpfErrorMessage = cpfRes.message,
        )

        if (firstNameRes.isValid && lastNameRes.isValid && emailRes.isValid && passwordRes.isValid && confirmPasswordRes.isValid && cpfRes.isValid) {
            return true
        }
        return false
    }
}

package com.example.greenwallet.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.greenwallet.data.validation.Validator
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel : ViewModel() {
    internal var registerState = mutableStateOf(RegisterState())

    fun onEvent (event: UIEvent){
        when(event){
            is UIEvent.FirstsNameChange -> {
                registerState.value = registerState.value.copy(
                    firstName = event.firstName
                )
                validateData()
            }
            is UIEvent.LastNameChange -> {
                registerState.value = registerState.value.copy(
                    lastName = event.lastName
                )
                validateData()
            }
            is UIEvent.EmailChange -> {
                registerState.value = registerState.value.copy(
                    email = event.email
                )
                validateData()
            }
            is UIEvent.PasswordChange -> {
                registerState.value = registerState.value.copy(
                    password = event.password
                )
                validateData()
            }
            is UIEvent.ConfirmPasswordChange -> {
                registerState.value = registerState.value.copy(
                    confirmPassword = event.confirmPassword
                )
                validateData()
            }
            is UIEvent.CpfChange -> {
                registerState.value = registerState.value.copy(
                    cpf = event.cpf
                )
                validateData()
            }
            is UIEvent.UserTermsChange -> {
                registerState.value = registerState.value.copy(
                    userTermsError = event.userTerms
                )
            }
            is UIEvent.RegisterButtonClick -> {
                register()
            }
        }
    }

    private fun register() {
        if (validateData()){
            createUser(
                email = registerState.value.email,
                password = registerState.value.password
            )
        }
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

        val userTermsRes = Validator.validateUserTerms(
            userTerms = registerState.value.userTermsError
        )

        registerState.value = registerState.value.copy(
            firstNameError = firstNameRes.isValid,
            lastNameError = lastNameRes.isValid,
            emailError = emailRes.isValid,
            passwordError = passwordRes.isValid,
            confirmPasswordError = confirmPasswordRes.isValid,
            cpfError = cpfRes.isValid,
            userTermsError = userTermsRes.isValid,
            firstNameErrorMessage = firstNameRes.message,
            lastNameErrorMessage = lastNameRes.message,
            emailErrorMessage = emailRes.message,
            passwordErrorMessage = passwordRes.message,
            confirmPasswordErrorMessage = confirmPasswordRes.message,
            cpfErrorMessage = cpfRes.message,
            userTermsErrorMessage = userTermsRes.message
        )

        if (firstNameRes.isValid && lastNameRes.isValid && emailRes.isValid && passwordRes.isValid && confirmPasswordRes.isValid && cpfRes.isValid && userTermsRes.isValid) {
            return true
        }
        return false
    }

    private fun createUser(email: String, password: String){
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    //TODO: Navigate to Success Screen
                }
            }
            .addOnFailureListener{

            }
    }
}



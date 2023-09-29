package com.example.greenwallet.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.greenwallet.data.UIEvent
import com.example.greenwallet.data.classes.User
import com.example.greenwallet.data.states.RegisterState
import com.example.greenwallet.data.validation.Validator
import com.example.greenwallet.navigation.ScreensRoutes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class RegisterViewModel (
    private val navController: NavController,
) : ViewModel() {

    internal var registerState = mutableStateOf(RegisterState())
    private val db = Firebase.database
    private val usersRef: DatabaseReference = db.getReference("users")
    fun onEvent (event: UIEvent){
        when(event){
            is UIEvent.FirstsNameChange -> {
                registerState.value = registerState.value.copy(
                    firstName = event.firstName
                )
                validateFirstName()
            }
            is UIEvent.LastNameChange -> {
                registerState.value = registerState.value.copy(
                    lastName = event.lastName
                )
                validateLastName()
            }
            is UIEvent.EmailChange -> {
                registerState.value = registerState.value.copy(
                    email = event.email
                )
                validateEmail()
            }
            is UIEvent.PasswordChange -> {
                registerState.value = registerState.value.copy(
                    password = event.password
                )
                validatePassword()
            }
            is UIEvent.ConfirmPasswordChange -> {
                registerState.value = registerState.value.copy(
                    confirmPassword = event.confirmPassword
                )
                validateConfirmPassword()
            }
            is UIEvent.CpfChange -> {
                registerState.value = registerState.value.copy(
                    cpf = event.cpf
                )
                validateCPF()
            }
            is UIEvent.UserTermsChange -> {
                registerState.value = registerState.value.copy(
                    userTermsError = event.userTerms
                )
                validateUserTerms()
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

    private fun createUser(email: String, password: String){
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    val user = User(
                        uid = it.result?.user?.uid ?: "",
                        firstName = registerState.value.firstName,
                        lastName = registerState.value.lastName,
                        email = email,
                        cpf = registerState.value.cpf
                    )

                    val userId = usersRef.push().key ?: ""
                    usersRef.child(userId).setValue(user)

                    navController.navigate(ScreensRoutes.RegisterSuccessScreen.route)
                }
            }
            .addOnFailureListener{

            }
    }
    private fun validateFirstName(): Boolean {
        val firstNameRes = Validator.validateFirstName(
            firstName = registerState.value.firstName, navController.context
        )
        registerState.value = registerState.value.copy(
            firstNameError = firstNameRes.isValid,
            firstNameErrorMessage = firstNameRes.message
        )
        return firstNameRes.isValid
    }

    private fun validateLastName(): Boolean {
        val lastNameRes = Validator.validateLastName(
            lastName = registerState.value.lastName, navController.context
        )
        registerState.value = registerState.value.copy(
            lastNameError = lastNameRes.isValid,
            lastNameErrorMessage = lastNameRes.message
        )
        return lastNameRes.isValid
    }

    private fun validateEmail(): Boolean {
        val emailRes = Validator.validateEmail(
            email = registerState.value.email, navController.context
        )
        registerState.value = registerState.value.copy(
            emailError = emailRes.isValid,
            emailErrorMessage = emailRes.message
        )
        return emailRes.isValid
    }

    private fun validatePassword(): Boolean {
        val passwordRes = Validator.validatePassword(
            password = registerState.value.password, navController.context
        )
        registerState.value = registerState.value.copy(
            passwordError = passwordRes.isValid,
            passwordErrorMessage = passwordRes.message
        )
        return passwordRes.isValid
    }

    private fun validateConfirmPassword(): Boolean {
        val confirmPasswordRes = Validator.validateConfirmPassword(
            password = registerState.value.password,
            confirmPassword = registerState.value.confirmPassword, navController.context
        )
        registerState.value = registerState.value.copy(
            confirmPasswordError = confirmPasswordRes.isValid,
            confirmPasswordErrorMessage = confirmPasswordRes.message
        )
        return confirmPasswordRes.isValid
    }

    private fun validateCPF(): Boolean {
        val cpfRes = Validator.validateCPF(
            cpf = registerState.value.cpf, navController.context
        )
        registerState.value = registerState.value.copy(
            cpfError = cpfRes.isValid,
            cpfErrorMessage = cpfRes.message
        )
        return cpfRes.isValid
    }

    private fun validateUserTerms(): Boolean {
        val userTermsRes = Validator.validateUserTerms(
            userTerms = registerState.value.userTermsError, navController.context
        )
        registerState.value = registerState.value.copy(
            userTermsError = userTermsRes.isValid,
            userTermsErrorMessage = userTermsRes.message
        )
        return userTermsRes.isValid
    }

    private fun validateData(): Boolean{
        return validateFirstName()
                && validateLastName()
                && validateEmail()
                && validatePassword()
                && validateConfirmPassword()
                && validateCPF()
                && validateUserTerms()
    }
}





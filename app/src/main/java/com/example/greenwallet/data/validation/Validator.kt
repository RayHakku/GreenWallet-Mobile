package com.example.greenwallet.data.validation

import android.content.Context
import com.example.greenwallet.R
import com.google.firebase.database.DatabaseReference

object Validator {

    fun validateFirstName(firstName: String, context: Context): ValidationRes {
        return if (firstName.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.first_name_must_not_be_empty)
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateLastName(lastName: String, context: Context): ValidationRes {
        return if (lastName.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.surname_must_not_be_empty)
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateEmail(email: String, context: Context): ValidationRes{
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (email.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.email_must_not_be_empty)
            )
        } else if (!email.matches(emailPattern.toRegex())) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.invalid_email_address)
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateCPF(cpf: String, context: Context, databaseReference: DatabaseReference): ValidationRes {
        return if (cpf.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.security_social_number_must_not_be_empty)
            )
        } else if (cpf.length != 11) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.invalid_social_security_number)
            )
        } /*else if (!existCPF(databaseReference, cpf)) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.social_security_number_already_registered)
            )
        }*/ else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validatePassword(password: String, context: Context): ValidationRes {
        return if (password.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.password_must_not_be_empty)
            )
        } else if (password.length < 8) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.password_must_be_at_least_8_characters_long)
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String, context: Context): ValidationRes {
        return if (confirmPassword.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.password_confirmation_must_not_be_empty)
            )
        } else if (password != confirmPassword) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.passwords_don_t_match)
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateUserTerms(userTerms: Boolean, context: Context): ValidationRes {
        return if (!userTerms) {
            ValidationRes(
                isValid = false,
                message = context.getString(R.string.agree_to_the_terms_of_use)
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    /*private fun existCPF (databaseReference: DatabaseReference, cpf: String): Boolean{
        if(databaseReference.child(cpf).get().addOnCompleteListener{
            it.exists()
            }){
            return false
        }
        return true
    }*/

}

data class ValidationRes(
    val isValid: Boolean = false,
    val message: String
)


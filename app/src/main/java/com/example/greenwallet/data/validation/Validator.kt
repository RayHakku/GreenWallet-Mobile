package com.example.greenwallet.data.validation

object Validator {
    fun validateFirstName(firstName: String): ValidationRes {
        return if (firstName.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = "Primeiro Nome nao pode estar vazio"
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateLastName(lastName: String): ValidationRes {
        return if (lastName.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = "Sobrenome nao pode estar vazio"
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateEmail(email: String): ValidationRes{
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (email.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = "Email nao pode estar vazio"
            )
        } else if (!email.matches(emailPattern.toRegex())) {
            ValidationRes(
                isValid = false,
                message = "Email invalido"
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateCPF(cpf: String): ValidationRes {
        return if (cpf.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = "CPF nao pode estar vazio"
            )
        } else if (cpf.length != 11) {
            ValidationRes(
                isValid = false,
                message = "CPF invalido"
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validatePassword(password: String): ValidationRes {
        return if (password.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = "Senha nao pode estar vazia"
            )
        } else if (password.length < 8) {
            ValidationRes(
                isValid = false,
                message = "Senha deve conter no minimo 8 caracteres"
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): ValidationRes {
        return if (confirmPassword.isEmpty()) {
            ValidationRes(
                isValid = false,
                message = "Confirmacao de senha nao pode estar vazia"
            )
        } else if (password != confirmPassword) {
            ValidationRes(
                isValid = false,
                message = "Senhas nao conferem"
            )
        } else {
            ValidationRes(
                isValid = true,
                message = ""
            )
        }
    }

}

data class ValidationRes(
    val isValid: Boolean = false,
    val message: String
)


package com.example.e_commerce_app.ui.theme.core.utils

object AppValidators {
    fun validateName(name: String): String? {
        return if (name.trim().isEmpty()) "Please enter name" else null
    }

    fun validEmail(email: String): String? {
        val trimmed = email.trim()
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        return when {
            trimmed.isEmpty() -> "Please enter email"
            !trimmed.matches(emailRegex) -> "Please enter valid email"
            else -> null
        }
    }

    fun validatePhone(phone: String): String? {
        val trimmed = phone.trim()
        return when {
            trimmed.isEmpty() -> "Please enter mobile number"
            trimmed.length < 11 -> "Mobile number is invalid"
            else -> null
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "Please enter password"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }
    }

    fun validateRePassword(password: String, rePassword: String): String? {
        return when {
            rePassword.isEmpty() -> "Please enter password"
            rePassword != password -> "Re-Password doesn't match Password"
            else -> null
        }
    }
}

package com.example.e_commerce_app.ui.theme.core.utils

object AppValidators {
    // todo : validate name
    fun validateName(name: String): String? {
        return if (name.trim().isEmpty())"Please enter name" else null
    }
    // todo : validate email
    fun validEmail(email: String): String? {
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        return when{
            email.trim().isEmpty() -> "please enter email"
            !email.matches(emailRegex) -> "please enter valid email"
            else -> null
        }
    }
    // todo : validate phone
    fun validatePhone(phone: String): String? {
        return when{
            phone.trim().isEmpty() -> "please enter mobile number"
            phone.length<11 -> " mobile number is invalid "
            else -> null
        }
    }
    // todo : validate password
    fun validatePassword(password: String): String? {
        return when{
            password.trim().isEmpty() -> "please enter password"
            password.length<6 -> " password should ba at least 6 char "
            else -> null
        }
    }
    // todo : validate rePassword
    fun validateRePassword(password: String, rePassword : String): String? {
        return when{
            rePassword.trim().isEmpty() -> "please enter password"
            rePassword != password-> "Re-Password Doesn't match Password"
            else -> null
        }
    }



}
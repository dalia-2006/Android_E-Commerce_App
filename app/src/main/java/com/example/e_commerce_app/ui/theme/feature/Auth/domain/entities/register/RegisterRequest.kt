package com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.register

data class RegisterRequest(

	val password: String? = null,

	val phone: String? = null,

	val rePassword: String? = null,

	val name: String? = null,

	val email: String? = null
)
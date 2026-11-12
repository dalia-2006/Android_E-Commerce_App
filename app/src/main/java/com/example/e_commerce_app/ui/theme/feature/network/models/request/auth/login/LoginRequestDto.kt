package com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.login

import com.google.gson.annotations.SerializedName

data class LoginRequestDto(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
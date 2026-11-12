package com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.register

import com.google.gson.annotations.SerializedName

data class RegisterRequestDto(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("rePassword")
	val rePassword: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
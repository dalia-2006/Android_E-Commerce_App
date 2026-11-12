package com.example.e_commerce_app.ui.theme.feature.network.models.response.auth

import com.google.gson.annotations.SerializedName

data class UserDto(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
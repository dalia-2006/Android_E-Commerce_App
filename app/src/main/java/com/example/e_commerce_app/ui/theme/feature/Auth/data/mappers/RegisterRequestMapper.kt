package com.example.e_commerce_app.ui.theme.feature.Auth.data.mappers

import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.login.LoginRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.register.RegisterRequest
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.login.LoginRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.register.RegisterRequestDto

fun RegisterRequest.toRegisterRequestDto(): RegisterRequestDto{
return RegisterRequestDto(
    email = this.email,
    password = this.password,
    phone = this.phone,
    rePassword = this.rePassword,
    name = this.name
    )
}
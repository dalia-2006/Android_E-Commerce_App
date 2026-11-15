package com.example.e_commerce_app.ui.theme.feature.Auth.data.mappers

import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.login.LoginRequest
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.login.LoginRequestDto

fun LoginRequest.toLoginRequestDto(): LoginRequestDto{
return LoginRequestDto(
    email = this.email,
    password = this.password
)
}
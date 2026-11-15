package com.example.e_commerce_app.ui.theme.feature.Auth.domain.repositories

import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.login.LoginRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.register.RegisterRequest
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult

interface AuthRepository {
    suspend fun login(loginRequest : LoginRequest): ApiResult<Unit>
    suspend fun register(registerRequest : RegisterRequest): ApiResult<Unit>

}
package com.example.e_commerce_app.ui.theme.feature.Auth.data.dataSources.remote

import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.login.LoginRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.register.RegisterRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.response.auth.AuthResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult

interface AuthRemoteDataSource {
    suspend fun login(loginRequestDto: LoginRequestDto): ApiResult<AuthResponseDto>
    suspend fun register(registerRequestDto: RegisterRequestDto): ApiResult<AuthResponseDto>

}
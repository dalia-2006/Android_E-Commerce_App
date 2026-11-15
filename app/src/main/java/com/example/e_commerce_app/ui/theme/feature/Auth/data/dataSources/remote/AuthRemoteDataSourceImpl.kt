package com.example.e_commerce_app.ui.theme.feature.Auth.data.dataSources.remote

import com.example.e_commerce_app.ui.theme.feature.network.api.ApiServices
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.login.LoginRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.register.RegisterRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.response.auth.AuthResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import com.example.e_commerce_app.ui.theme.feature.network.utility.safeApiCall
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor (
    val apiServices: ApiServices
): AuthRemoteDataSource {
    override suspend fun login(loginRequestDto: LoginRequestDto): ApiResult<AuthResponseDto>  =
        safeApiCall{
            apiServices.login(loginRequest = loginRequestDto)
        }

    override suspend fun register(registerRequestDto: RegisterRequestDto): ApiResult<AuthResponseDto> =safeApiCall{
        apiServices.register(registerRequestDto)
    }
}
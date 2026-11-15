package com.example.e_commerce_app.ui.theme.feature.Auth.data.repository

import com.example.e_commerce_app.ui.theme.core.errors.AppErrors
import com.example.e_commerce_app.ui.theme.feature.Auth.data.dataSources.remote.AuthRemoteDataSource
import com.example.e_commerce_app.ui.theme.feature.Auth.data.mappers.toLoginRequestDto
import com.example.e_commerce_app.ui.theme.feature.Auth.data.mappers.toRegisterRequestDto
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.login.LoginRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.register.RegisterRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.repositories.AuthRepository
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val authRemoteDataSource: AuthRemoteDataSource
): AuthRepository{
    override suspend fun login(loginRequest: LoginRequest): ApiResult<Unit> {
        //todo : LoginRequest ==> LoginRequestDto
     return when (val result = authRemoteDataSource.login(loginRequestDto = loginRequest.toLoginRequestDto())) {
            is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(AppErrors.ServerError(result.error.errorMessage))
            is ApiResult.SuccessApiResult<*> -> ApiResult.SuccessApiResult(data = Unit)
        }
    }

    override suspend fun register(registerRequest: RegisterRequest): ApiResult<Unit> {
        //todo : RegisterRequest ==> RegisterRequestDto
        return when(val result = authRemoteDataSource.register(registerRequest.toRegisterRequestDto())){
            is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(AppErrors.ServerError(message = result.error.errorMessage))
            is ApiResult.SuccessApiResult<*> -> ApiResult.SuccessApiResult(data = Unit)
        }
    }
}
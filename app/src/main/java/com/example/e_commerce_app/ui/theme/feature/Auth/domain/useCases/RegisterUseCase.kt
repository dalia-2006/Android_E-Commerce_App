package com.example.e_commerce_app.ui.theme.feature.Auth.domain.useCases

import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.login.LoginRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.register.RegisterRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.repositories.AuthRepository
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import javax.inject.Inject

class RegisterUseCase @Inject constructor ( val authRepository: AuthRepository){
    suspend fun invoke(registerRequest: RegisterRequest) : ApiResult<Unit> =
        authRepository.register(registerRequest = registerRequest)
}
package com.example.e_commerce_app.ui.theme.feature.network.utility

import com.example.e_commerce_app.ui.theme.core.errors.AppErrors

sealed interface ApiResult<out T> {
    data class SuccessApiResult <T>(val data : T?) : ApiResult<T>
    data class ErrorApiResult (val error: AppErrors ): ApiResult<Nothing>
}
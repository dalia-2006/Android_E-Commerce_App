package com.example.e_commerce_app.ui.theme.feature.network.utility

import com.example.e_commerce_app.ui.theme.core.errors.AppErrors
import com.example.e_commerce_app.ui.theme.feature.network.models.response.error.CustomResponseError
import com.google.gson.Gson
import okio.IOException
import retrofit2.HttpException

suspend fun<T> safeApiCall(
    apiCall :suspend () -> T
) : ApiResult<T>{
    return try {
        ApiResult.SuccessApiResult(data = apiCall() )
    }catch (e: HttpException){
        val gson =  e.response()?.errorBody()?.string()
        val error = Gson().fromJson(gson, CustomResponseError :: class.java)
        return ApiResult.ErrorApiResult(error = AppErrors.ServerError(message =error.message))
    }catch (e: IOException){
        ApiResult.ErrorApiResult(error = AppErrors.NetworkError(message =e.localizedMessage))
    }catch (e : Throwable){
        ApiResult.ErrorApiResult(error = AppErrors.UnKnownError(message =e.localizedMessage))
    }
}
/**
 *
 * suspend fun <T> safeApiCall(
 *     apiCall: suspend () -> T
 * ): ApiResult<T> {
 *     return try {
 *         ApiResult.SuccessApiResult(data = apiCall())
 *
 *     } catch (e: HttpException) {
 *         val json = e.response()?.errorBody()?.string()
 *         val error: CustomResponseError? =
 *             json?.let {
 *                 Gson().fromJson(it, CustomResponseError::class.java)
 *             }
 *
 *         ApiResult.ErrorApiResult(
 *             error = AppErrors.ServerError(message = error?.message)
 *         )
 *
 *     } catch (e: IOException) {
 *         ApiResult.ErrorApiResult(
 *             error = AppErrors.NetworkError(message = e.localizedMessage)
 *         )
 *
 *     } catch (e: Throwable) {
 *         ApiResult.ErrorApiResult(
 *             error = AppErrors.UnKnownError(message = e.localizedMessage)
 *         )
 *     }
 * }
 *
 */
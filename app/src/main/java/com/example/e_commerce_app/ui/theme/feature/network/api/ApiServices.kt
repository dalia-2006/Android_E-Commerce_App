package com.example.e_commerce_app.ui.theme.feature.network.api

import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.login.LoginRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.request.auth.register.RegisterRequestDto
import com.example.e_commerce_app.ui.theme.feature.network.models.response.auth.AuthResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.models.response.category.CategoryResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.models.response.product.ProductResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    @POST(ApiEndPoints.LOGIN)
 suspend  fun login (@Body loginRequest : LoginRequestDto) : AuthResponseDto

    @POST(ApiEndPoints.REGISTER)
  suspend  fun register (@Body registerRequest : RegisterRequestDto):AuthResponseDto

    @GET(ApiEndPoints.CATEGORIES)
   suspend fun getAllCategories () : CategoryResponseDto

    @GET(ApiEndPoints.BRANDS)
     suspend fun getAllBrands(): CategoryResponseDto

    @GET(ApiEndPoints.PRODUCTS)
    suspend fun getAllProducts () : ProductResponseDto
}
package com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.remote.home

import com.example.e_commerce_app.ui.theme.feature.network.models.response.category.CategoryResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult

interface HomeRemoteDataSource {
    suspend fun getAllCategory () : ApiResult<CategoryResponseDto>
    suspend fun getAllBrands () : ApiResult<CategoryResponseDto>

}
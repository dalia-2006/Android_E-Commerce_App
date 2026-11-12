package com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.remote.home

import com.example.e_commerce_app.ui.theme.feature.network.api.ApiServices
import com.example.e_commerce_app.ui.theme.feature.network.models.response.category.CategoryResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import com.example.e_commerce_app.ui.theme.feature.network.utility.safeApiCall
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(val apiServices: ApiServices) : HomeRemoteDataSource{
    override suspend fun getAllCategory(): ApiResult<CategoryResponseDto>  = safeApiCall{
        apiServices.getAllCategories()
    }

    override suspend fun getAllBrands(): ApiResult<CategoryResponseDto>   = safeApiCall{
        apiServices.getAllBrands()
    }

}
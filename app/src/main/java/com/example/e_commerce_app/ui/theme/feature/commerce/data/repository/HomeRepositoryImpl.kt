package com.example.e_commerce_app.ui.theme.feature.commerce.data.repository

import com.example.e_commerce_app.ui.theme.core.errors.AppErrors
import com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.mappers.toCategory
import com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.remote.home.HomeRemoteDataSource
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.repositories.home.HomeRepository
import com.example.e_commerce_app.ui.theme.feature.network.models.response.category.CategoryResponseDto
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val homeRemoteDataSource: HomeRemoteDataSource) : HomeRepository {
    override suspend fun getAllCategories(): ApiResult<List<CategoryItem>> {
        // todo :  ApiResult<CategoryResponseDto> ==> ApiResult<List<CategoryItem>>
         return when(
            val result = homeRemoteDataSource.getAllCategory()
        ) {
            is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = result.error.errorMessage))
            is ApiResult.SuccessApiResult<CategoryResponseDto> -> {
                  ApiResult.SuccessApiResult(data = result.data?.data
                    ?.map {categoryItemDto ->
                       return@map categoryItemDto?.toCategory()
                    }?.filterNotNull() ?: emptyList()
                )
            }
        }
    }

    override suspend fun getAllBrands(): ApiResult<List<CategoryItem>> {
        return when(val result = homeRemoteDataSource.getAllBrands()) {
            is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = result.error.errorMessage))
            is ApiResult.SuccessApiResult<CategoryResponseDto> -> {
                ApiResult.SuccessApiResult(data = result.data?.data
                    ?.map {categoryItemDto ->
                        return@map categoryItemDto?.toCategory()
                    }?.filterNotNull() ?: emptyList()
                )
            }
        }
    }
}

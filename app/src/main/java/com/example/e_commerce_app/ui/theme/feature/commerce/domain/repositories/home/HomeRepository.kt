package com.example.e_commerce_app.ui.theme.feature.commerce.domain.repositories.home

import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult

interface HomeRepository {
     suspend fun getAllCategories (): ApiResult<List<CategoryItem>>
     suspend fun getAllBrands (): ApiResult<List<CategoryItem>>
}
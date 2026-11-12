package com.example.e_commerce_app.ui.theme.feature.commerce.domain.useCases

import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.repositories.home.HomeRepository
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import javax.inject.Inject

class GetAllBrandsUseCase @Inject constructor (val homeRepository: HomeRepository) {
     suspend fun invoke (): ApiResult<List<CategoryItem>> {
        return homeRepository.getAllBrands()
    }

}
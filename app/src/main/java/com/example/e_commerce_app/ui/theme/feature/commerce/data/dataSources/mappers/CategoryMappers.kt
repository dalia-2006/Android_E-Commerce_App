package com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.mappers

import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.network.models.response.common.CategoryItemDto

fun CategoryItemDto.toCategory() : CategoryItem{
    return CategoryItem(
        image=this.image,
        name= this.name,
        id = this.id,
        category = this.category
        )
}
package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home

import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility.Resource

data class HomeStates(
    val categoryState : Resource<List<CategoryItem>> = Resource.Initial,
    val brandState : Resource<List<CategoryItem>> = Resource.Initial
)

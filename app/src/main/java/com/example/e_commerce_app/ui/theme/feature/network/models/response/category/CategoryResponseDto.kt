package com.example.e_commerce_app.ui.theme.feature.network.models.response.category

import com.example.e_commerce_app.ui.theme.feature.network.models.response.common.CategoryItemDto
import com.example.e_commerce_app.ui.theme.feature.network.models.response.common.MetadataDto
import com.google.gson.annotations.SerializedName

data class CategoryResponseDto(

    @field:SerializedName("metadata")
	val metadata: MetadataDto? = null,

    @field:SerializedName("data")
	val data: List<CategoryItemDto?>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)
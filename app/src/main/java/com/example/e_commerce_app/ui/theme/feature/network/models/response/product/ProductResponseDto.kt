package com.example.e_commerce_app.ui.theme.feature.network.models.response.product

import com.example.e_commerce_app.ui.theme.feature.network.models.response.common.MetadataDto
import com.google.gson.annotations.SerializedName

data class ProductResponseDto(

	@field:SerializedName("metadata")
	val metadata: MetadataDto? = null,

	@field:SerializedName("data")
	val data: List<ProductItemDto?>? = null,

	@field:SerializedName("results")
	val results: Int? = null
)
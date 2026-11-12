package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility.Resource
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.composable.AdsSectionLayout
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.composable.HomeSuccessLayout
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.composable.MainSectionLayout
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.common.MainErrorSection
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.common.MainLoadingSection

@Composable
fun HomeTab(modifier: Modifier = Modifier,
            viewModel: HomeViewModel = hiltViewModel()
) {
    val colorScheme = MaterialTheme.colorScheme
    val state  by viewModel.state.collectAsStateWithLifecycle()
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            vertical = 12.dp,
            horizontal = 16.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        item {
            Column(modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                AdsSectionLayout()
                MainSectionLayout(
                    text = "Categories",
                    textButton = "View All"
                )
                when ( val categoryState = state.categoryState ){
                    is Resource.Error -> MainErrorSection(
                        onTryAgainClick = {},
                        errorMessage = categoryState.errorMessage
                    )
                    Resource.Initial -> MainLoadingSection()
                    Resource.Loading -> MainLoadingSection()
                    is Resource.Success<List<CategoryItem>> -> HomeSuccessLayout(
                        categoriesList = categoryState.data
                    )
                }

                MainSectionLayout(
                    text = "Brands",
                    textButton = "View All"
                )
                when ( val brandStates = state.brandState ){
                    is Resource.Error -> MainErrorSection(
                        onTryAgainClick = {},
                        errorMessage = brandStates.errorMessage
                    )
                    Resource.Initial -> MainLoadingSection()
                    Resource.Loading -> MainLoadingSection()
                    is Resource.Success<List<CategoryItem>> -> HomeSuccessLayout(
                        categoriesList = brandStates.data
                    )
                }
            }        }
    }

}
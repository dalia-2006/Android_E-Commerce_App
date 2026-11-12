package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_app.ui.theme.core.errors.AppErrors
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.useCases.GetAllBrandsUseCase
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.useCases.GetAllCategoryUseCase
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility.Resource
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val getAllCategoryUseCase: GetAllCategoryUseCase,
    val getAllBrandsUseCase: GetAllBrandsUseCase
) : ViewModel(){
    // todo : states ( initial , loading , success , error )
    private val _states : MutableStateFlow<HomeStates> = MutableStateFlow(HomeStates())
    val state : StateFlow<HomeStates>  = _states.asStateFlow()

    init {
        loadCategory()
        loadBrands()
    }

    fun loadCategory (){
        viewModelScope.launch {
            //todo : loading
            _states.value = _states.value.copy(categoryState = Resource.Loading)
            when (val result = getAllCategoryUseCase.invoke()){
                //todo : error
                is ApiResult.ErrorApiResult ->
                    _states.value = _states.value.copy(
                        categoryState = Resource.Error(errorMessage = result.error.errorMessage)
                    )
                //todo: success
                is ApiResult.SuccessApiResult<List<CategoryItem>> ->
                    _states.value = _states.value.copy(
                        categoryState = Resource.Success(data = result.data!!)
                    )
            }

        }

    }
    fun loadBrands (){
        viewModelScope.launch {

            //todo : loading
            _states.value = _states.value.copy(brandState = Resource.Loading)

            when (val result = getAllBrandsUseCase.invoke()){

                //todo : error
                is ApiResult.ErrorApiResult ->
                    _states.value = _states.value.copy(
                        brandState = Resource.Error(errorMessage = result.error.errorMessage)
                    )

                //todo: success
                is ApiResult.SuccessApiResult<List<CategoryItem>> ->
                    _states.value = _states.value.copy(
                        brandState = Resource.Success(data = result.data!!)
                    )

            }
        }
        }

}

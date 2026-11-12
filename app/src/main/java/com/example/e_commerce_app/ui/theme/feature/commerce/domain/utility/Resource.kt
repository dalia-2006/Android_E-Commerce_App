package com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility

//todo: States
sealed interface Resource<out T> {
    data object Loading : Resource<Nothing>
    data object Initial : Resource<Nothing>
    data class Success <T>( val data : T ): Resource<T>
    data class Error ( val errorMessage : String): Resource<Nothing>
}
package com.example.e_commerce_app.ui.theme.core.errors

sealed class AppErrors (val errorMessage: String) {

    data class NetworkError ( val message : String? = "No Internet Connection Please try Again Later") : AppErrors(errorMessage = message!!)
    data class ServerError (val message: String?="Server down Please try Again Later") : AppErrors(errorMessage = message!!)
    data class UnKnownError (val message: String?="Something went wrong Please try Again Later") : AppErrors(errorMessage = message!!)

}
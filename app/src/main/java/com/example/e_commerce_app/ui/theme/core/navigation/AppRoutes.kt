package com.example.e_commerce_app.ui.theme.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object LoginRoute {
}

@Serializable
object RegisterRoute {
}

@Serializable
data class HomeRoute (var name:String = ""){
}
@Serializable
object HomeTabRoute {
}
@Serializable
object CategoryTabRoute {
}
@Serializable
object FavouriteTabRoute {
}
@Serializable
object ProfileTabRoute {
}




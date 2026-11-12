package com.example.e_commerce_app.ui.theme.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Screens.MainScreen.HomeScreen
import com.example.e_commerce_app.ui.theme.feature.Auth.ui.screens.login.LoginScreen
import com.example.e_commerce_app.ui.theme.feature.Auth.ui.screens.register.RegisterScreen

@Composable
fun AppNavigation (modifier: Modifier= Modifier){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ){
        composable<RegisterRoute> {
            RegisterScreen(
                onSignUpClick = {fullName ->
                    navController.navigate(HomeRoute("")){
                        popUpTo<RegisterRoute>{
                            inclusive=true
                        }
                    }
                }
            )
        }
        composable<LoginRoute> {
            LoginScreen (
                onLoginClick = {
                    navController.navigate(HomeRoute("")){
                        popUpTo<LoginRoute>{
                            inclusive =true
                        }
                    }
                },
                onCreateAccountClick = {
                    navController.navigate(RegisterRoute)
                }
            )
        }
        composable<HomeRoute> {
            val args = it.toRoute<HomeRoute>()
            HomeScreen (fullName = args.name)
        }
    }
}
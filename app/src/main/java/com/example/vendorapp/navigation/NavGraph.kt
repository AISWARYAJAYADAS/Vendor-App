package com.example.vendorapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.vendorapp.screens.home.HomeScreen
import com.example.vendorapp.screens.login.LoginScreen
import com.example.vendorapp.screens.signup.SignupScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = AppRoutes.SignupScreen) {
        composable<AppRoutes.SignupScreen> {
            SignupScreen(navController)
        }
        composable<AppRoutes.SignInScreen>{
            LoginScreen(navController)
        }
        composable<AppRoutes.HomeScreen> { backStackEntry ->
            val route: AppRoutes.HomeScreen = backStackEntry.toRoute()
            HomeScreen(navController,route)
        }
    }
}

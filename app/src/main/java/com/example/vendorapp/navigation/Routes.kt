package com.example.vendorapp.navigation

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    object SignupScreen
    @Serializable
    object SignInScreen
    @Serializable
    data class HomeScreen(val userName:String)
}
package com.example.vendorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.vendorapp.navigation.NavGraph
import com.example.vendorapp.screens.UserListScreen
import com.example.vendorapp.screens.signup.SignupScreen
import com.example.vendorapp.ui.theme.VendorAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VendorAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}


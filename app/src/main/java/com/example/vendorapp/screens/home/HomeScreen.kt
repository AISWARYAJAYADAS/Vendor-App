package com.example.vendorapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.vendorapp.navigation.AppRoutes
import com.example.vendorapp.screens.UserListScreen

@Composable
fun HomeScreen(navHostController: NavHostController,
               userName: AppRoutes.HomeScreen) {
    Column (
       modifier =  Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = userName.userName)
       // UserListScreen()
    }

}
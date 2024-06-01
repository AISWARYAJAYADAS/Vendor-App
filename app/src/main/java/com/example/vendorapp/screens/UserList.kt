package com.example.vendorapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vendorapp.model.user.GetUsersResponseItem
import com.example.vendorapp.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen() {
    val userViewModel: UserViewModel = hiltViewModel()

    val users by userViewModel.users.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        userViewModel.fetchUsers()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User List") }
            )
        }
    ) {it
        Box(modifier = Modifier.padding(it)) {
            UserList(users = users)
        }
    }
}

@Composable
fun UserList(users: List<GetUsersResponseItem>) {
    LazyColumn {
        items(users) { user ->
            UserItem(user = user)
        }
    }
}

@Composable
fun UserItem(user: GetUsersResponseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
       // elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Name: ${user.name}")
            Text(text = "Email: ${user.email}")
            // Add more user details as needed
        }
    }
}

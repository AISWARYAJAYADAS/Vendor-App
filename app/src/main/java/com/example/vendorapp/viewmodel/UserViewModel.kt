package com.example.vendorapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vendorapp.api.ApiService
import com.example.vendorapp.model.user.GetUsersResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    private val _users = MutableStateFlow<List<GetUsersResponseItem>>(emptyList())
    val users: StateFlow<List<GetUsersResponseItem>> = _users

    fun fetchUsers() {
        viewModelScope.launch {
            _users.value = apiService.getUsers()
        }
    }
}


sealed class GetUserResult {
    data class Success(val message: String) : GetUserResult()
    data class Error(val message: String) : GetUserResult()
}
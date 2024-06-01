package com.example.vendorapp.viewmodel

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vendorapp.api.ApiService
import com.example.vendorapp.model.user.CreateUserRequest
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

    private val _createUserResult = MutableStateFlow<CreateUserResult?>(null)
    val createUserResult: StateFlow<CreateUserResult?> = _createUserResult

    // State variables for user input
    var userName by mutableStateOf("")
    var userEmail by mutableStateOf("")
    var userPhone by mutableStateOf("")
    var userAddress by mutableStateOf("")
    var userPincode by mutableStateOf("")
    var password by mutableStateOf("")


    fun fetchUsers() {
        viewModelScope.launch {
            _users.value = apiService.getUsers()
        }
    }

    fun createUser(
        password: String,
        userName: String,
        userAddress: String,
        userEmail: String,
        userPhone: String,
        userPincode: String
    ) {
        val request = CreateUserRequest(
            password = password,
            name = userName,
            address = userAddress,
            email = userEmail,
            phone = userPhone,
            pincode = userPincode
        )
        viewModelScope.launch {
            try {
                val response = apiService.createUser(request)
                // Handle success
                _createUserResult.value = CreateUserResult.Success(response.message)
            } catch (e: Exception) {
                // Handle error
                _createUserResult.value = CreateUserResult.Error(e.message ?: "Unknown error")
            }
        }
    }


}


sealed class CreateUserResult {
    data class Success(val message: String) : CreateUserResult()
    data class Error(val message: String) : CreateUserResult()
}
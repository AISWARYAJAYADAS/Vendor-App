package com.example.vendorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vendorapp.api.ApiService
import com.example.vendorapp.model.user.CreateUserRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _createUserResult = MutableStateFlow<CreateUserResult?>(CreateUserResult.Idle)
    val createUserResult: StateFlow<CreateUserResult?> = _createUserResult

    // State variables for user input
    var userName by mutableStateOf("")
    var userEmail by mutableStateOf("")
    var userPhone by mutableStateOf("")
    var userAddress by mutableStateOf("")
    var userPincode by mutableStateOf("")
    var password by mutableStateOf("")

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
            _createUserResult.value = CreateUserResult.Loading
            try {
                val response = apiService.createUser(request)
                _createUserResult.value = CreateUserResult.Success(response.message)
            } catch (e: Exception) {
                _createUserResult.value = CreateUserResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class CreateUserResult {
    object Loading : CreateUserResult()
    data class Success(val message: String) : CreateUserResult()
    data class Error(val message: String) : CreateUserResult()
    object Idle : CreateUserResult()
}

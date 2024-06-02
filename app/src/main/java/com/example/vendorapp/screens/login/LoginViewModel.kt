package com.example.vendorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vendorapp.api.ApiService
import com.example.vendorapp.model.user.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _loginResult = MutableStateFlow<LoginResult?>(LoginResult.Idle)
    val loginResult: StateFlow<LoginResult?> = _loginResult

    // State variables for user input
    var userEmail by mutableStateOf("")
    var password by mutableStateOf("")

    fun loginUser(email: String, password: String) {
        val request = LoginRequest(email = email, password = password)
        viewModelScope.launch {
            _loginResult.value = LoginResult.Loading
            try {
                val response = apiService.loginUser(request)
                _loginResult.value = LoginResult.Success(response.message)
            } catch (e: Exception) {
                _loginResult.value = LoginResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class LoginResult {
    object Loading : LoginResult()
    data class Success(val message: String) : LoginResult()
    data class Error(val message: String) : LoginResult()
    object Idle : LoginResult()
}

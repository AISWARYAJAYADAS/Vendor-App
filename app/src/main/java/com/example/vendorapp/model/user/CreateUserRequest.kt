package com.example.vendorapp.model.user

data class CreateUserRequest(
    val address: String,
    val email: String,
    val name: String,
    val password: String,
    val phone: String,
    val pincode: String
)
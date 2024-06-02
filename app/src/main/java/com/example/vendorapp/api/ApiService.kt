package com.example.vendorapp.api

import com.example.vendorapp.model.user.CreateUserRequest
import com.example.vendorapp.model.user.CreateUserResponse
import com.example.vendorapp.model.user.GetUsersResponse
import com.example.vendorapp.model.user.LoginRequest
import com.example.vendorapp.model.user.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    companion object {
        // const val BASE_URL = "http://127.0.0.1:5000/"
        const val BASE_URL = "https://ajzzz.pythonanywhere.com"
        //   const val BASE_URL = "http://192.168.1.8:5000/"
    }

    @GET("/users")
    suspend fun getUsers(): GetUsersResponse

    @POST("create_user")
    suspend fun createUser(@Body request: CreateUserRequest): CreateUserResponse

    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest): LoginResponse


}
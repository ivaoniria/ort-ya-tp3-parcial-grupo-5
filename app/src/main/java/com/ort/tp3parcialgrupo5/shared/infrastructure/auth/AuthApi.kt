package com.ort.tp3parcialgrupo5.shared.infrastructure.auth

import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.TokenResponse
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.LoginRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.CreateUserRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<TokenResponse>

    @POST("auth/create")
    suspend fun createAccount(@Body request: CreateUserRequest): Response<UserResponse>
}

package com.ort.tp3parcialgrupo5.shared.infrastructure.auth

import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.Token
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.LoginRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.CreateUserRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.ApiResult
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.safeApiCall

class AuthImpl : Auth {

    private val authApi = RetrofitClient.getRetrofit().create(AuthApi::class.java)

    override suspend fun login(data: LoginRequest): Token? {
        return when (val result = safeApiCall { authApi.login(data) }) {
            is ApiResult.Success -> result.data.toModel()
            is ApiResult.Error -> {
                println("Error logging in: ${result.exception.message}")
                null
            }
            is ApiResult.Loading -> null
        }
    }

    override suspend fun createUser(data: CreateUserRequest): User? {
        return when (val result = safeApiCall { authApi.createAccount(data) }) {
            is ApiResult.Success -> result.data.toModel()
            is ApiResult.Error -> {
                println("Error creating user: ${result.exception.message}")
                null
            }
            is ApiResult.Loading -> null
        }
    }
}

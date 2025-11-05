package com.ort.tp3parcialgrupo5.shared.infrastructure.user

import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getUserInfo(@Path("id") userId: Int): Response<UserResponse>
}

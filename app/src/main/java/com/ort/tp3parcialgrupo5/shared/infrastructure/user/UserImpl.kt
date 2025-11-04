package com.ort.tp3parcialgrupo5.shared.infrastructure.user

import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.ApiResult
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.safeApiCall

class UserImpl : UserService {

    private val userApi = RetrofitClient.getRetrofit().create(UserApi::class.java)

    override suspend fun getUserInfo(userId: String): User? {
        return when (val result = safeApiCall { userApi.getUserInfo(userId) }) {
            is ApiResult.Success -> result.data.toModel()
            is ApiResult.Error -> {
                println("Error fetching user info: ${result.exception.message}")
                null
            }
            is ApiResult.Loading -> null
        }
    }
}

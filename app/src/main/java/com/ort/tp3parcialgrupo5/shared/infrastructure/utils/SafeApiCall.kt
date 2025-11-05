package com.ort.tp3parcialgrupo5.shared.infrastructure.utils

import retrofit2.Response

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                ApiResult.Success(body)
            } else {
                ApiResult.Error(Exception("Response body is null"))
            }
        } else {
            ApiResult.Error(Exception("HTTP ${response.code()}: ${response.message()}"))
        }
    } catch (e: Exception) {
        ApiResult.Error(e)
    }
}


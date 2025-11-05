package com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("token") val token: String
) {
    fun toModel(): Token = Token(token = token)
}

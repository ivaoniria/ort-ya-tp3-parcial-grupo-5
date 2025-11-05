package com.ort.tp3parcialgrupo5.shared.infrastructure.auth

import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.LoginRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.CreateUserRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.Token
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User

interface Auth {
    suspend fun login(data: LoginRequest): Token?
    suspend fun createUser(data: CreateUserRequest): User?
}

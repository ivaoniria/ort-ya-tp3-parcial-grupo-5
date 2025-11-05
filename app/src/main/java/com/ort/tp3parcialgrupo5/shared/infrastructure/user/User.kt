package com.ort.tp3parcialgrupo5.shared.infrastructure.user

import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User

interface UserService {
    suspend fun getUserInfo(userId: Int): User?
}

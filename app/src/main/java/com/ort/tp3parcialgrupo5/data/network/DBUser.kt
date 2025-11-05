package com.ort.tp3parcialgrupo5.data.network

import com.ort.tp3parcialgrupo5.shared.infrastructure.user.UserImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User
import javax.inject.Inject

class DBUser @Inject constructor(
    private val userImpl: UserImpl
) {
    suspend fun getUserInfo(userId: Int): User? {
        return userImpl.getUserInfo(userId)
    }
}


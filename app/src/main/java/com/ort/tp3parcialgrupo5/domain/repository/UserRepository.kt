package com.ort.tp3parcialgrupo5.domain.repository

import com.ort.tp3parcialgrupo5.domain.model.DbUser
import kotlinx.coroutines.flow.Flow
interface UserRepository {
    fun getUserList(): Flow<List<DbUser>>
    suspend fun getUserById(id: Int): DbUser?
    suspend fun getLastUser(): DbUser?
    suspend fun getUserCount(): Int
    suspend fun insertUser(user: DbUser)
    suspend fun updateUser(user: DbUser)
    suspend fun deleteUser(user: DbUser)
    suspend fun clearUsers()
}
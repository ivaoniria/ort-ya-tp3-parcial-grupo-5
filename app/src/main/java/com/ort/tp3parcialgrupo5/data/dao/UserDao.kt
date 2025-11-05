/*package com.ort.tp3parcialgrupo5.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ort.tp3parcialgrupo5.data.network.DBUser
import com.ort.tp3parcialgrupo5.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM $USER_TABLE ORDER BY id ASC")
    fun getUserList(): Flow<List<DBUser>>
    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): UserModel?
    @Insert
    suspend fun insertUser(user: UserModel)
    @Update
    suspend fun updateUser(user: UserModel)
    @Delete
    suspend fun deleteUser(user: UserModel)
}

*/
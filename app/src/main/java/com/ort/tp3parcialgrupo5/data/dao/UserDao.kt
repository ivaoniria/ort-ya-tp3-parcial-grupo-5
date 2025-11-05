package com.ort.tp3parcialgrupo5.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ort.tp3parcialgrupo5.core.USER_TABLE
import com.ort.tp3parcialgrupo5.domain.model.DbUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM $USER_TABLE ORDER BY id ASC")
    fun getUserList(): Flow<List<DbUser>>

    @Query("SELECT * FROM $USER_TABLE WHERE id = :id")
    suspend fun getUserById(id: Int): DbUser?

    @Query("SELECT * FROM $USER_TABLE ORDER BY id DESC LIMIT 1")
    suspend fun getLastUser(): DbUser?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: DbUser)

    @Update
    suspend fun updateUser(user: DbUser)

    @Delete
    suspend fun deleteUser(user: DbUser)
    
    @Query("SELECT COUNT(id) FROM $USER_TABLE")
    suspend fun getUserCount(): Int
}

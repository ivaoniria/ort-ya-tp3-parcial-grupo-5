package com.ort.tp3parcialgrupo5.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ort.tp3parcialgrupo5.data.dao.UserDao
import com.ort.tp3parcialgrupo5.domain.model.DbUser

@Database(
    entities = [DbUser::class],
    version = 4,
    exportSchema = false
)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}

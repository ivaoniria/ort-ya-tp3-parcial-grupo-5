package com.ort.tp3parcialgrupo5.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ort.tp3parcialgrupo5.core.USER_TABLE
import com.ort.tp3parcialgrupo5.navigation.DBUserDetails

@Entity(tableName = USER_TABLE)
data class DbUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    val email: String
)

fun DbUser.toUserDetails() = DBUserDetails(
    id = this.id,
    username = this.username,
    email = this.email
)
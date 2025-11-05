package com.ort.tp3parcialgrupo5.navigation

import kotlinx.serialization.Serializable

@Serializable
data class DBUserDetails(
    val id: Int,
    val username: String,
    val email: String
)
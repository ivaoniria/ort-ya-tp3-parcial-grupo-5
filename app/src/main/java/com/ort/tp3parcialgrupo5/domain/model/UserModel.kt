package com.ort.tp3parcialgrupo5.domain.model

data class UserModel(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val city: String,
    val street: String,
    val streetNumber: Int,
    val zipcode: String,
    val latitude: String,
    val longitude: String
)


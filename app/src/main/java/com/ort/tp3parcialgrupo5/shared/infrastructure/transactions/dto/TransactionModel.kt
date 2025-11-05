package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto

data class TransactionModel(
    val transaction_id: String,
    val date: String,
    val description: String,
    val amount: Double,
    val currency: String,
    val type: String,
    val subtype: String
)

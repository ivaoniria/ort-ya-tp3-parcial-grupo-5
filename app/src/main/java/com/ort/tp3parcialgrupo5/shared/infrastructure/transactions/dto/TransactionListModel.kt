package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto

data class TransactionsList(
    val userId: String,
    val balance: Double,
    val income: Double,
    val expense: Double,
    val transactions: List<TransactionModel>
)

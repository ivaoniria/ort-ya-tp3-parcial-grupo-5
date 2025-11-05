package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto

import com.google.gson.annotations.SerializedName

data class TransactionsListResponse(
    @SerializedName("user_id") val userId: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("income") val income: Double,
    @SerializedName("expense") val expense: Double,
    @SerializedName("transactions") val transactions: List<TransactionResponse>
) {
    fun toModel(): TransactionsList =
        TransactionsList(
            userId = userId,
            balance = balance,
            income = income,
            expense = expense,
            transactions = transactions.map { it.toModel() }
        )
}

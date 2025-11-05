package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto

import com.google.gson.annotations.SerializedName

data class TransactionResponse(
    @SerializedName("transaction_id") val transactionId: String,
    @SerializedName("date") val date: String,
    @SerializedName("description") val description: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("type") val type: String,
    @SerializedName("subtype") val subtype: String
) {
    fun toModel(): TransactionModel =
        TransactionModel(
            transaction_id = transactionId,
            date = date,
            description = description,
            amount = amount,
            currency = currency,
            type = type,
            subtype = subtype
        )
}

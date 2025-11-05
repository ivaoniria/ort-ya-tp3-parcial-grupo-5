package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions

import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionsList
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.ApiResult
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.safeApiCall

class TransactionsImpl : Transaction {

    private val transactionsApi = RetrofitClient.getRetrofit().create(TransactionsApi::class.java)

    override suspend fun getTransactions(): TransactionsList? {
        return when (val result = safeApiCall { transactionsApi.getTransactions() }) {
            is ApiResult.Success -> result.data.toModel()
            is ApiResult.Error -> {
                println("Error fetching transactions: ${result.exception.message}")
                null
            }
            is ApiResult.Loading -> null
        }
    }
}

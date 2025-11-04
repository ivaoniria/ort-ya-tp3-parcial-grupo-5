package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions

import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionsListResponse
import retrofit2.Response
import retrofit2.http.GET

interface TransactionsApi {
    @GET("transactions")
    suspend fun getTransactions(): Response<TransactionsListResponse>
}

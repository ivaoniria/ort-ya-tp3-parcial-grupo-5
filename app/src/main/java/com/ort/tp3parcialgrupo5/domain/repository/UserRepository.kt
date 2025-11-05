package com.ort.tp3parcialgrupo5.domain.repository

import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.TransactionsApi
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionsListResponse

class UserRepository(private val apiService: TransactionsApi) {

    suspend fun getUserAccountData(): Result<TransactionsListResponse> {
        return try {
            val resp = apiService.getTransactions()
            if (resp.isSuccessful && resp.body() != null) {
                Result.success(resp.body()!!)
            } else {
                val direct = apiService.getTransactionsDirect("${RetrofitClient.BASE_URL}transactions")
                if (direct.isSuccessful && direct.body() != null) {
                    Result.success(direct.body()!!)
                } else {
                    Result.failure(Exception("HTTP ${resp.code()} ${resp.message()} / ${direct.code()} ${direct.message()}"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

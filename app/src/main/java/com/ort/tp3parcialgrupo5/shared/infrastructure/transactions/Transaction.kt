package com.ort.tp3parcialgrupo5.shared.infrastructure.transactions

import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionsList

interface Transaction {
    suspend fun getTransactions(): TransactionsList?
}

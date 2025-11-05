package com.ort.tp3parcialgrupo5.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ort.tp3parcialgrupo5.domain.repository.TransactionsRepository
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: TransactionsRepository) : ViewModel() {

    private val _totalBalance = mutableStateOf(0.0)
    val totalBalance: State<Double> = _totalBalance

    private val _totalIncome = mutableStateOf(0.0)
    val totalIncome: State<Double> = _totalIncome

    private val _totalExpense = mutableStateOf(0.0)
    val totalExpense: State<Double> = _totalExpense

    private val _transactions = mutableStateOf<List<TransactionResponse>>(emptyList())
    val transactions: State<List<TransactionResponse>> = _transactions

    private val _isLoading = mutableStateOf(true)
    private val _errorMessage = mutableStateOf<String?>(null)

    init {
        fetchUserAccount()
    }

    private fun fetchUserAccount() {
        viewModelScope.launch {
            val result = repository.getUserAccountData()
            result.onSuccess { userAccount ->
                _totalBalance.value = userAccount.balance
                _totalIncome.value = userAccount.income
                _totalExpense.value = userAccount.expense
                _transactions.value = userAccount.transactions
            }.onFailure { exception ->
                android.util.Log.e("HomeViewModel", "Repo error", exception)
                _errorMessage.value = "Error al cargar los datos: ${exception.message}"
            }
            _isLoading.value = false
        }
    }
}

class HomeViewModelFactory(private val repository: TransactionsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

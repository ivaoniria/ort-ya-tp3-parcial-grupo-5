package com.ort.tp3parcialgrupo5

import android.util.Log
import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object DebugTools {
    fun runApiSmokeIfAvailable() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.i("ApiSmokeTester", "===================== API SMOKE TEST =====================")
                val userRes = RetrofitClient.userApi.getUserInfo(1)
                if (userRes.isSuccessful) {
                    val u = userRes.body()
                    if (u != null) {
                        Log.i("ApiSmokeTester", "OK user:")
                        Log.i("ApiSmokeTester", "id=${u.id}, address=${u.address}, name=${u.name}, username=${u.username}, password=${u.password}, email=${u.email}, phone=${u.phone}")
                    } else {
                        Log.e("ApiSmokeTester", "Body de usuario es null")
                    }
                } else {
                    Log.e("ApiSmokeTester", "Fallo user: code=${userRes.code()} msg=${userRes.message()}")
                }

                val txRes = RetrofitClient.transactionsApi.getTransactions()
                if (txRes.isSuccessful) {
                    val acc = txRes.body()
                    if (acc != null) {
                        Log.i("ApiSmokeTester", "OK account:")
                        Log.i("ApiSmokeTester", "userId=${acc.userId}, balance=${acc.balance}, income=${acc.income}, expense=${acc.expense}, txCount=${acc.transactions.size}")
                        acc.transactions.firstOrNull()?.let { first ->
                            Log.i("ApiSmokeTester", "Primera transacción: $first")
                        }
                    } else {
                        Log.e("ApiSmokeTester", "Body de account es null")
                    }
                } else {
                    Log.e("ApiSmokeTester", "Fallo transactions: code=${txRes.code()} msg=${txRes.message()}")
                }
                Log.i("ApiSmokeTester", "==========================================================")
            } catch (t: Throwable) {
                withContext(Dispatchers.Main) {
                    Log.e("ApiSmokeTester", "Excepción en smoke test", t)
                }
            }
        }
    }
}

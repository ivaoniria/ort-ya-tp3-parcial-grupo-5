package com.ort.tp3parcialgrupo5.shared.infrastructure

import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.AuthImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.Token
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.LoginRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.dto.CreateUserRequest
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.UserImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.TransactionsImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionsList
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val apiKey = "123456789"

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("x-api-key", apiKey)
                .header("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        })
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://51af05f3-5390-4931-ae9b-4892e5ef9f61.mock.pstmn.io/")
        .client(httpClient)
        .build()

    fun getRetrofit(): Retrofit = retrofit

}

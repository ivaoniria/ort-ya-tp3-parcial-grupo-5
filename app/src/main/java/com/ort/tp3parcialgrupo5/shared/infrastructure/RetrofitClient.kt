package com.ort.tp3parcialgrupo5.shared.infrastructure

import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.AuthApi
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.TransactionsApi
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.UserApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "https://51af05f3-5390-4931-ae9b-4892e5ef9f61.mock.pstmn.io/"

    private const val API_KEY = "123456789"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val headers = Interceptor { chain ->
        val original = chain.request()
        val req = original.newBuilder()
            .header("Content-Type", "application/json")
            .header("x-api-key", API_KEY)
            .header("x-mock-response-code", "200")
            .build()
        chain.proceed(req)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(headers)
        .addInterceptor(logging)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val authApi: AuthApi by lazy { retrofit.create(AuthApi::class.java) }
    val transactionsApi: TransactionsApi by lazy { retrofit.create(TransactionsApi::class.java) }
    val userApi: UserApi by lazy { retrofit.create(UserApi::class.java) }

    fun getRetrofit(): Retrofit = retrofit
}

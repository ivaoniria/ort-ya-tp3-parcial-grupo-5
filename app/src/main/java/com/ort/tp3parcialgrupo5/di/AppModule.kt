package com.ort.tp3parcialgrupo5.di

import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.AuthImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.UserImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.TransactionsImpl
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.Auth
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.UserService
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.Transaction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAuthImpl(authImpl: AuthImpl): Auth

    @Binds
    @Singleton
    abstract fun bindUserImpl(userImpl: UserImpl): UserService

    @Binds
    @Singleton
    abstract fun bindTransactionsImpl(transactionsImpl: TransactionsImpl): Transaction
}


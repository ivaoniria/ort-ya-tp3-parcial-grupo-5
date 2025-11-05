package com.ort.tp3parcialgrupo5.di

import android.content.Context
import androidx.room.Room
import com.ort.tp3parcialgrupo5.data.dao.UserDao
import com.ort.tp3parcialgrupo5.data.network.UserDb
import com.ort.tp3parcialgrupo5.data.repository.UserRepositoryImpl
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.Auth
import com.ort.tp3parcialgrupo5.shared.infrastructure.auth.AuthImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDb(
        @ApplicationContext context: Context
    ): UserDb =
        Room.databaseBuilder(
            context,
            UserDb::class.java,
            "user_db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideUserDao(userDb: UserDb): UserDao = userDb.userDao()

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository =
        UserRepositoryImpl(userDao = userDao)

    @Provides
    @Singleton
    fun provideLoginService(): Auth = AuthImpl()
}

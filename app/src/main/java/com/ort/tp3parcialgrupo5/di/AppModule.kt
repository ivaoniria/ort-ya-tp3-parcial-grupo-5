import android.content.Context
import androidx.room.Room
import com.ort.tp3parcialgrupo5.R
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
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideUserDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        UserDb::class.java,
        "user_db"
    ).build()

    @Provides
    fun provideUserDao(
        userDb: UserDb
    ) = userDb.userDao

    @Provides
    fun provideUserRepository(
        userDao: UserDao
    ): UserRepository = UserRepositoryImpl(
        userDao = userDao
    )

    @Provides
    @Singleton
    fun provideLoginService(): Auth {
        return AuthImpl()
    }
}
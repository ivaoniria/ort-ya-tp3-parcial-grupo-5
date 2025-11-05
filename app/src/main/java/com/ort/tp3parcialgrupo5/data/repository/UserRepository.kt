/*package com.ort.tp3parcialgrupo5.data.repository

import com.ort.tp3parcialgrupo5.data.dao.UserDao
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository
import com.ort.tp3parcialgrupo5.shared.infrastructure.user.dto.User

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override fun getUserList() = userDao.getUserList()

    override suspend fun getUserById(id: Int) = userDao.getUserById(id)

    override suspend fun insertUser(book: User) = userDao.insertUser(user)

    override suspend fun updateUser(book: User) = userDao.updateUser(user)

    override suspend fun deleteUser(book: User) = userDao.deleteUser(user)
}
*/
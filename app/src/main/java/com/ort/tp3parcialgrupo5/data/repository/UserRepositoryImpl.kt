package com.ort.tp3parcialgrupo5.data.repository

import com.ort.tp3parcialgrupo5.data.dao.UserDao
import com.ort.tp3parcialgrupo5.domain.model.DbUser
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override fun getUserList() = userDao.getUserList()

    override suspend fun getUserById(id: Int) = userDao.getUserById(id)

    override suspend fun getLastUser(): DbUser? = userDao.getLastUser()

    override suspend fun getUserCount(): Int = userDao.getUserCount()

    override suspend fun insertUser(user: DbUser) = userDao.insertUser(user)

    override suspend fun updateUser(user: DbUser) = userDao.updateUser(user)

    override suspend fun deleteUser(user: DbUser) = userDao.deleteUser(user)

    override suspend fun clearUsers() = userDao.clearUsers()
}

package com.example.mvvmdaggerhiltroomDB.repository

import com.example.mvvmdaggerhiltroomDB.dao.UserDao
import com.example.mvvmdaggerhiltroomDB.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao : UserDao) {
    val getUserData : Flow<List<User>> = userDao.getUserData()

    suspend fun insert(user : User) = withContext(Dispatchers.IO)
    {
        userDao.insert(user)
    }

}
package com.example.mc2024.data.room

import com.example.mc2024.data.entity.Users
import com.example.mc2024.data.room.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun getUserWithUsername(username: String): Users? = userDao.findByName(username)

    val getUserDetails: Flow<List<Users>> get() =  userDao.getUserDetails()

    suspend fun addUser(user: Users) : Long {
        return userDao.insertUser(user)
    }
}
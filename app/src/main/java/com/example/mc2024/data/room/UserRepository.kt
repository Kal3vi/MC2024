/*package com.example.mc2024.data.room

import com.example.mc2024.data.entity.User
import com.example.mc2024.data.room.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun getUserWithUsername(username: String): User? = userDao.findByName(username)

    val getUserDetails: Flow<List<User>> get() =  userDao.getUserDetails()

    suspend fun addUser(user: User) : Long {
        return userDao.insertUser(user)
    }
}*/
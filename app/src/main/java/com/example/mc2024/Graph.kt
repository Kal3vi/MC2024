package com.example.mc2024

import android.content.Context
import androidx.room.Room
import com.example.mc2024.data.repository.PaymentRepository
import com.example.mc2024.data.room.CategoryRepository
import com.example.mc2024.data.room.MCDatabase
//import com.example.mc2024.data.room.UserRepository

/**
 * A simple singleton dependency graph
 *
 * For a real app, please use something like Koin/Dagger/Hilt instead
 */
object Graph {
    lateinit var database: MCDatabase

    lateinit var appContext: Context
/*
    val userRepository by lazy {
        UserRepository(
            userDao = database.UserDao()
        )
    }*/
    val paymentRepository by lazy {
        PaymentRepository(
            paymentDao = database.paymentDao()
        )
    }

    val categoryRepository by lazy {
        CategoryRepository(
            categoryDao = database.categoryDao()
        )
    }

    fun provide(context: Context) {
        appContext = context
        database = Room.databaseBuilder(context, MCDatabase::class.java, "mcData.db")
            .fallbackToDestructiveMigration() // don't use this in production app
            .build()
    }
}
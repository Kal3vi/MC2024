package com.example.mc2024

import android.content.Context
import androidx.room.Room
import com.example.mc2024.data.room.MCDatabase
import com.example.mc2024.data.room.CategoryRepository
import com.example.mc2024.data.room.ReminderRepository

object Graph {
    lateinit var database: MCDatabase
        private set

    // Give context to the whole application
    lateinit var appContext: Context

    val categoryRepository by lazy {
        CategoryRepository(
            categoryDao =  database.categoryDao()
        )
    }

    val reminderRepository by lazy {
        ReminderRepository(
            reminderDao =  database.reminderDao()
        )
    }


    fun provide(context: Context){
        appContext = context
        database = Room.databaseBuilder(context, MCDatabase::class.java, "data.db")
            .allowMainThreadQueries()       // Fix an error "Cannot access database on the main thread
            .build()
    }
}
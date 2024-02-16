package com.example.mc2024.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mc2024.data.entity.Category
import com.example.mc2024.data.entity.Reminder

//import com.example.mc2024.data.room.PaymentDao
//import com.example.mc2024.data.entity.Payment

//import com.example.mc2024.data.entity.Converters
//import com.example.mc2024.data.entity.User

@Database(
    entities = [Category::class, Reminder::class],
    version = 2,
    exportSchema = false
)
abstract class MCDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun reminderDao(): ReminderDao
}
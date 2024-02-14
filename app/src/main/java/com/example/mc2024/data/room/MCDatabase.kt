package com.example.mc2024.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//import com.example.mc2024.data.entity.Converters
import com.example.mc2024.data.entity.Users

@Database(
    entities = [Users::class],
    version = 1,
    exportSchema = false
)
abstract class MCDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}
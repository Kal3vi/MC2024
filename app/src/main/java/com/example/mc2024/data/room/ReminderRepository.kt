package com.example.mc2024.data.room

import com.example.mc2024.data.room.ReminderDao
import com.example.mc2024.data.room.ReminderToCategory
import com.example.mc2024.data.entity.Reminder
import kotlinx.coroutines.flow.Flow

// Reminder data repository
class ReminderRepository (
    private val reminderDao: ReminderDao
){
    fun remindersInCategory(categoryId: Long) : Flow<List<ReminderToCategory>> {
        return reminderDao.remindersFromCategory(categoryId)
    }

    // Add new reminder
    suspend fun addReminder(reminder: Reminder) = reminderDao.insert(reminder)
}
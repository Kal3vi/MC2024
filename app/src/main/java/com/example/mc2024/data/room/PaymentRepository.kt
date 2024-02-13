package com.example.mc2024.data.repository

import com.example.mc2024.data.entity.Payment
import com.example.mc2024.data.room.PaymentDao
import com.example.mc2024.data.room.PaymentToCategory
//import com.example.courseapp.data.room.PaymentToCategory
import kotlinx.coroutines.flow.Flow

/**
 * A data repository for [Payment] instances
 */
class PaymentRepository(
    private val paymentDao: PaymentDao
) {
    /**
     * Returns a flow containing the list of payments associated with the category with the
     * given [categoryId]
     */
    fun paymentsInCategory(categoryId: Long) : Flow<List<PaymentToCategory>> {
        return paymentDao.paymentsFromCategory(categoryId)
    }

    /**
     * Add a new [Payment] to the payment store
     */
    suspend fun addPayment(payment: Payment) = paymentDao.insert(payment)
}
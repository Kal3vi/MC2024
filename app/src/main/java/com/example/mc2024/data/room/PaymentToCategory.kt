package com.example.mc2024.data.room

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.example.mc2024.data.entity.Category
import com.example.mc2024.data.entity.Payment
import java.util.Objects

class PaymentToCategory {
    @Embedded
    lateinit var payment: Payment

    @Relation(parentColumn = "payment_category_id", entityColumn = "id")
    lateinit var _categories: List<Category>

    @get:Ignore
    val category: Category
        get() = _categories[0]

    /**
     * Allow this class to be destructured by consumers
     */
    operator fun component1() = payment
    operator fun component2() = category

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is PaymentToCategory -> payment == other.payment && _categories == other._categories
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(payment, _categories)
}
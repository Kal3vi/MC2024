package com.example.mc2024.UserInterface.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mc2024.Graph
import com.example.mc2024.data.entity.Category
import com.example.mc2024.data.room.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


/*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mc2024.data.entity.User
import com.example.mc2024.data.room.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    private val _selectedUser = MutableStateFlow<User?>(null)

    val state: StateFlow<HomeViewState>
        get() = _state

    fun onUserSelected(user: User) {
        _selectedUser.value = user
    }

    init {
        viewModelScope.launch {
            userRepository.getUserDetails
        }
    }
}

data class HomeViewState(
    val selectedUser: User? = null
)*/

class HomeViewModel(
    private val categoryRepository: CategoryRepository = Graph.categoryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    private val _selectedCategory = MutableStateFlow<Category?>(null)

    val state: StateFlow<HomeViewState>
        get() = _state

    fun onCategorySelected(category: Category) {
        _selectedCategory.value = category
    }

    init {
        viewModelScope.launch {

            combine(
                categoryRepository.categories().onEach { list ->
                    if (list.isNotEmpty() && _selectedCategory.value == null) {
                        _selectedCategory.value = list[0]
                    }
                },
                _selectedCategory
            ) { categories, selectedCategory ->
                HomeViewState(
                    categories = categories,
                    selectedCategory = selectedCategory
                )
            }.collect { _state.value = it }
        }

        loadCategoriesFromDb()
    }

    private fun loadCategoriesFromDb() {
        val list = mutableListOf(
            Category(name = "Food"),
            Category(name = "Health"),
            Category(name = "Savings"),
            Category(name = "Drinks"),
            Category(name = "Clothing"),
            Category(name = "Investment"),
            Category(name = "Travel"),
            Category(name = "Fuel"),
            Category(name = "Repairs"),
            Category(name = "Coffee")
        )
        viewModelScope.launch {
            list.forEach { category -> categoryRepository.addCategory(category) }
        }
    }
}

data class HomeViewState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null
)
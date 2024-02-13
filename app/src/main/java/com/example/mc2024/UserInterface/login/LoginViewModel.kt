/*package com.example.mc2024.UserInterface.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mc2024.Graph
import com.example.mc2024.data.entity.User
import com.example.mc2024.data.room.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepository: UserRepository = Graph.userRepository
) : ViewModel() {
    private val _response = MutableLiveData<Long>()
    suspend fun saveUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(userRepository.addUser(user))
        }
    }

    private val _userDetails = MutableStateFlow<List<User>>(emptyList())
    val userDetails : StateFlow<List<User>> =  _userDetails

    fun doGetUserDetails(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserDetails
                .catch { e->
                    //Log error here
                }
                .collect {
                    _userDetails.value = it
                }
        }
    }
    //private val _state = MutableStateFlow(LoginViewState())

    //val response: LiveData<Long> = _response

    //val state: StateFlow<LoginViewState>
    //    get() = _state


/*
    init {
        viewModelScope.launch {
            userRepository.getUserDetails
        }
    }*/
}

data class LoginViewState(
    val selectedUser: User? = null
)*/
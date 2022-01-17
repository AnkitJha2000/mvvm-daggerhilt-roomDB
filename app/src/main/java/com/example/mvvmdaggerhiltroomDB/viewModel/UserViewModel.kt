package com.example.mvvmdaggerhiltroomDB.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmdaggerhiltroomDB.model.User
import com.example.mvvmdaggerhiltroomDB.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel(){

    val getUserData:LiveData<List<User>> = userRepository.getUserData
        .flowOn(Dispatchers.Main)
        .asLiveData(context = viewModelScope.coroutineContext)
    fun insert(user : User) = viewModelScope.launch {
        userRepository.insert(user)
    }
}
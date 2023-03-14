package com.dhanshri.coroutine_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActicityViewModel: ViewModel() {
//    private val myScope = CoroutineScope(Dispatchers.IO)
    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>?> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result
        }
    }
}
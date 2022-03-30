package com.example.sapinterview.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sapinterview.data.entities.User
import com.example.sapinterview.data.remote.ApiResponse
import com.example.sapinterview.domain.UserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val useCase: UserUseCase): ViewModel() {

    private val _user = MutableLiveData<List<User>>()
    val user: LiveData<List<User>>
        get() = _user

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var job: Job? = null

    init {
        getUser()
    }

    private fun getUser() {
        _isLoading.value = true
        job = CoroutineScope(Dispatchers.Default).launch {
            val result = useCase.getUserUseCase()
            _isLoading.postValue(false)
            when(result) {
                is ApiResponse.SUCCESS -> _user.postValue(result.item!!)
                is ApiResponse.ERROR -> _error.postValue(result.errorMessage)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()

    }
}
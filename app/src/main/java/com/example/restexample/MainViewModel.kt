package com.example.restexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel:ViewModel() {
    private val _post=MutableLiveData<MyPost>()
    val post:LiveData<MyPost>
        get() = _post

    private val _isLoading= MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _hasError= MutableLiveData<Boolean>()
    val hasError:LiveData<Boolean>
        get() = _hasError

    init {
        fetchPost()
    }

    fun fetchPost(){
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            val post: Response<MyPost> = RetrofitInstance.api.fetchPost()
            if (post.isSuccessful) {
                _post.value = post.body()
                _isLoading.value = false
                _hasError.value = false
            } else {
               // _hasError.value = true
            }
        }
    }
}
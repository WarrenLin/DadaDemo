package com.cmoney.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cmoney.mvvmdemo.model.ApiRepository
import com.cmoney.mvvmdemo.model.ApiRepository.Callback

class MainViewModel: ViewModel() {
    private val _serverResponse = MutableLiveData<String>()
    val serverResponse: LiveData<String> = _serverResponse

    private val model: ApiRepository = ApiRepository()

    fun onButtonClick() {
//        val serverString = model.fetchData()
//        _serverResponse.value = serverString

        model.fetchDataCallback(object : Callback {
            override fun onData(response: String) {
                _serverResponse.value = response
            }
        })

    }
}
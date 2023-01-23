package com.jhon.pokedex.base
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    protected fun showLoading(loadingValue: Boolean?) {
        _isLoading.value = loadingValue!!
    }

}
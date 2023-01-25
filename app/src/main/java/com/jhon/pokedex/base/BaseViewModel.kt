package com.jhon.pokedex.base
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jhon.domain.utils.Failure


abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    protected fun showLoading(loadingValue: Boolean?) {
        _isLoading.value = loadingValue!!
    }

    fun failer(failure: Failure) {
        Log.i("TAG", "failer: ${failure.toString()}")
    }


}
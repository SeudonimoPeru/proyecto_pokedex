package com.jhon.pokedex.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.usecases.GuardarPokemonesUseCases
import com.jhon.domain.usecases.PrincipalUseCase
import com.jhon.domain.utils.Failure
import com.jhon.pokedex.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrincipalViewModel(
    private val principalUseCase: PrincipalUseCase,
    private val guardarPokemonesUseCases: GuardarPokemonesUseCases
) : BaseViewModel() {

    private var _txtSearch = MutableLiveData("")
    val txtSearch: LiveData<String> get() = _txtSearch

    private var _listAllPoken = MutableLiveData<List<PokemonModel>>()
    private var _listAllPokenForFilter = MutableLiveData<List<PokemonModel>>()
    val listAllPoken: LiveData<List<PokemonModel>> = _listAllPokenForFilter

    fun getData() {
        showLoading(true)
        val params = PrincipalUseCase.Params(0, 150)
        viewModelScope.launch {
            principalUseCase.invoke(viewModelScope, params) {
                showLoading(false)
                it.either(::failer, ::handleGetListPokemon)

            }
        }
    }


    fun failer(failure: Failure) {
        Log.i("TAGGGG", "failer: ${failure.toString()}")
    }

    fun handleGetListPokemon(listPokemon: List<PokemonModel>) {
        _listAllPoken.value = listPokemon
        _listAllPokenForFilter.value = listPokemon
        val listPokemonParam = GuardarPokemonesUseCases.Params(listPokemon)
        viewModelScope.launch(Dispatchers.IO) {
            guardarPokemonesUseCases.invoke(viewModelScope, listPokemonParam) {
                it.either(::failer) {
                    Log.i(TAG, "handleGetListPokemon: Guardado con éxito")
                }
            }
        }
    }

    fun filterPokemon(query: String) {
        _listAllPokenForFilter.value = _listAllPoken.value
        viewModelScope.launch(Dispatchers.IO) {
            _listAllPokenForFilter.value?.let { list ->
                _listAllPokenForFilter.postValue(
                    list.filter {
                        it.name.contains(query, true)
                    }
                )
            }
        }
    }


}
package com.jhon.pokedex.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.usecases.PrincipalUseCase
import com.jhon.domain.utils.Failure
import com.jhon.pokedex.base.BaseViewModel
import kotlinx.coroutines.launch

class PrincipalViewModel(
    private val principalUseCase: PrincipalUseCase
) : BaseViewModel() {

    private var _txtSearch = MutableLiveData("")
    val txtSearch: LiveData<String> get() = _txtSearch

    private var _listAllPoken = MutableLiveData<List<PokemonModel>>()
    val listAllPoken: LiveData<List<PokemonModel>>  = _listAllPoken

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
    }


}
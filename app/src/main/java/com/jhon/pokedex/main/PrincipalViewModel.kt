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
import com.jhon.pokedex.mapper.PokemonMapperUI
import com.jhon.pokedex.model.PokemonUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalViewModel(
    private val principalUseCase: PrincipalUseCase,
    private val guardarPokemonesUseCases: GuardarPokemonesUseCases,
    private val pokemonMapperUI: PokemonMapperUI
) : BaseViewModel() {

    private var _txtSearch = MutableLiveData("")
    val txtSearch: LiveData<String> get() = _txtSearch

    private var _listAllPoken = MutableLiveData<List<PokemonUI>>()
    private var _listAllPokenForFilter = MutableLiveData<List<PokemonUI>>()
    val listAllPoken: LiveData<List<PokemonUI>> = _listAllPokenForFilter

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



    fun handleGetListPokemon(listPokemon: List<PokemonModel>) {


        viewModelScope.launch(Dispatchers.Main) {
            val listUI = withContext(Dispatchers.IO) {
                pokemonMapperUI.mapAllPokemonEntityToModel(listPokemon)
            }
            _listAllPoken.value = listUI
            _listAllPokenForFilter.value = listUI
            val listPokemonParam = GuardarPokemonesUseCases.Params(listPokemon)
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
package com.jhon.pokedex.main

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

    private var _txtSearch = MutableLiveData ("")
     val txtSearch : LiveData<String> get() = _txtSearch

    private var _listAllPoken = MutableLiveData<List<PokemonModel>>()
    val listAllPoken : LiveData<List<PokemonModel>> get() = _listAllPoken

    fun executeLogin() {

        val params = PrincipalUseCase.Params(0,150)
        viewModelScope.launch {
            principalUseCase.invoke(viewModelScope,params){
                   it.either(::failer,::handleGetListPokemon)

            }
        }
    }


    fun failer(failure: Failure){

    }

    fun handleGetListPokemon(listPokemon :List<PokemonModel>){

    }


}
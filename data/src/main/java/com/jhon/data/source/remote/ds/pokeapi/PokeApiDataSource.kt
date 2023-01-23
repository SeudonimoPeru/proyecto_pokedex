package com.jhon.data.source.remote.ds.pokeapi

import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

interface PokeApiDataSource {

suspend fun listaInventarioWithLimit(offset:Int , limit : Int) : Either<Failure, ListPokemonResponse>
}
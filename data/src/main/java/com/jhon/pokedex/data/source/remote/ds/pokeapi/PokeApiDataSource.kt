package com.jhon.pokedex.data.source.remote.ds.pokeapi

import com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle.PokemonDetalleResponse
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

interface PokeApiDataSource {

    suspend fun listaInventarioWithLimit(offset: Int, limit: Int): Either<Failure, ListPokemonResponse>
    suspend fun listaInventarioWithLimit(uriDetalle: String): Either<Failure, PokemonDetalleResponse>
}
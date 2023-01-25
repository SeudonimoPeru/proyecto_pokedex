package com.jhon.pokedex.data.source.remote.ds.pokeapi

import com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle.PokemonDetalleResponse
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

interface PokeApiDataSource {

    suspend fun getDetalleOfPokemon(offset: Int, limit: Int): Either<Failure, ListPokemonResponse>
    suspend fun getDetalleOfPokemon(uriDetalle: String): Either<Failure, PokemonDetalleResponse>
}
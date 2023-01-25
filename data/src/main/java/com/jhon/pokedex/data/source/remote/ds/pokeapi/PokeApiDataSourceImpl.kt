package com.jhon.pokedex.data.source.remote.ds.pokeapi

import com.jhon.pokedex.data.source.remote.base.CallServiceBase
import com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle.PokemonDetalleResponse
import com.jhon.pokedex.data.source.remote.service.PokeApiService
import com.jhon.pokedex.data.utils.ConnectionUtils
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

class PokeApiDataSourceImpl(
    private val pokeApiService: PokeApiService,
    private val connectionUtils: ConnectionUtils
) : PokeApiDataSource, CallServiceBase() {

    override fun getNetworkUtils() = connectionUtils

    override suspend fun getDetalleOfPokemon(offset: Int, limit: Int): Either<Failure, ListPokemonResponse> = callServiceWithOutBase {
        pokeApiService.getPokemonWithLimit(offset, limit)
    }

    override suspend fun getDetalleOfPokemon(uriDetalle: String): Either<Failure, PokemonDetalleResponse> = callServiceWithOutBase {
        pokeApiService.getDetallePokemon(uriDetalle)
    }

}
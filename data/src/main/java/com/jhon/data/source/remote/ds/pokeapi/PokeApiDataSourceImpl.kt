package com.jhon.data.source.remote.ds.pokeapi

import com.jhon.data.source.remote.base.CallServiceBase
import com.jhon.data.source.remote.service.PokeApiService
import com.jhon.data.utils.ConnectionUtils
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

class PokeApiDataSourceImpl(
    private val pokeApiService: PokeApiService,
    private val connectionUtils: ConnectionUtils
) : PokeApiDataSource, CallServiceBase() {

    override fun getNetworkUtils() = connectionUtils

    override suspend fun listaInventarioWithLimit(offset: Int, limit: Int): Either<Failure, ListPokemonResponse> = callServiceWithOutBase {
        pokeApiService.getPokemonWithLimit(offset, limit)
    }

}
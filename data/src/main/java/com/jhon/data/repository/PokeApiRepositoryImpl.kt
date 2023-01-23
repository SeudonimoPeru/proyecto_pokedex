package com.jhon.data.repository

import com.jhon.data.mapper.PokemonMapper
import com.jhon.data.source.local.room.ds.pokemones.AllPokemonDataSource
import com.jhon.data.source.remote.ds.pokeapi.PokeApiDataSource
import com.jhon.data.utils.ConnectionUtils
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.repository.PokeApiRepository
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure


class PokeApiRepositoryImpl(
    private val connection: ConnectionUtils,
    private val pokeRemoteDs: PokeApiDataSource,
    private val pokeLocalDs: AllPokemonDataSource,
    private val pokemonMapper: PokemonMapper,

    ): PokeApiRepository {

    override suspend fun getAllPokemonWithLimit(offset: Int, limit: Int): Either<Failure, List<PokemonModel>> {
        return if (connection.isNetworkAvailable()) {
            when (val response = pokeRemoteDs.listaInventarioWithLimit(offset, limit)) {
                is Either.Success -> Either.Success(pokemonMapper.mapListPokemonResponseToModel(response.success))
                is Either.Error -> Either.Error(response.error)
                else -> Either.Error(Failure.None)
            }
        } else {
            when (val response = pokeLocalDs.getAllPokemon()) {
                is Either.Success -> Either.Success(
                    pokemonMapper.mapAllPokemonEntityToModel(response.success)
                )
                is Either.Error -> Either.Error(response.error)
                else -> Either.Error(Failure.None)
            }
        }

    }
}
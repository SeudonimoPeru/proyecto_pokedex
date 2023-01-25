package com.jhon.pokedex.data.repository

import com.jhon.pokedex.data.mapper.PokemonMapper
import com.jhon.pokedex.data.source.local.room.ds.pokemones.AllPokemonDataSource
import com.jhon.pokedex.data.source.remote.ds.pokeapi.PokeApiDataSource
import com.jhon.pokedex.data.utils.ConnectionUtils
import com.jhon.domain.model.PokemonDetalleModel
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.repository.PokeApiRepository
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure


class PokeApiRepositoryImpl(
    private val connection: ConnectionUtils,
    private val pokeRemoteDs: PokeApiDataSource,
    private val pokeLocalDs: AllPokemonDataSource,
    private val pokemonMapper: PokemonMapper,

    ) : PokeApiRepository {


    override suspend fun getDetallePokemon(uriDetalle: String): Either<Failure, PokemonDetalleModel> {
        return when (val response = pokeRemoteDs.getDetalleOfPokemon(uriDetalle)) {

            is Either.Success -> {

                Either.Success(pokemonMapper.mapPokeMonDetalleResponseToModel(response.success))
            }
            is Either.Error -> Either.Error(response.error)
            else -> Either.Error(Failure.None)
        }
    }


    override suspend fun getAllPokemonWithLimit(offset: Int, limit: Int): Either<Failure, List<PokemonModel>> {
        return if (connection.isNetworkAvailable()) {
            when (val response = pokeRemoteDs.getDetalleOfPokemon(offset, limit)) {

                is Either.Success -> {

                    Either.Success(pokemonMapper.mapListPokemonResponseToModel(response.success))
                }
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

    override suspend fun insertAllPokemon(listPokemon: List<PokemonModel>): Either<Failure, Unit> {
        return when (val response = pokeLocalDs.insertAllPokemon(pokemonMapper.mapAllPokemonModelToEntitty(listPokemon))) {

            is Either.Success -> {

                Either.Success(response.success)
            }
            is Either.Error -> Either.Error(response.error)
            else -> Either.Error(Failure.None)
        }
    }

    override suspend fun deleteTablePokemon(): Either<Failure, Unit> {
        return when (val response = pokeLocalDs.deleteTablePokemon()) {

            is Either.Success -> {

                Either.Success(response.success)
            }
            is Either.Error -> Either.Error(response.error)
            else -> Either.Error(Failure.None)
        }
    }

}

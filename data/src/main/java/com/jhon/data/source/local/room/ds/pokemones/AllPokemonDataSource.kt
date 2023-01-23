package com.jhon.data.source.local.room.ds.pokemones

import com.jhon.data.source.local.room.db.entity.PokemonEntity
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

interface AllPokemonDataSource {

    suspend fun getAllPokemon(): Either<Failure, List<PokemonEntity>>
    suspend fun insertAllPokemon(listPokemonEntity: List<PokemonEntity>): Either<Failure, Unit>

    suspend fun getPokemonWithId(idPokemon: Int): Either<Failure, PokemonEntity?>
}
package com.jhon.data.source.local.room.ds.pokemones

import android.database.sqlite.SQLiteException
import com.jhon.data.source.local.room.db.dao.PokemonDao
import com.jhon.data.source.local.room.db.entity.PokemonEntity
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

class AllPokemonDataSourceImpl(
    private val pokemonDao: PokemonDao
) : AllPokemonDataSource {
    override suspend fun getAllPokemon(): Either<Failure, List<PokemonEntity>> {
        return try {
            Either.Success(pokemonDao.getAllPokemon())
        } catch (exception: SQLiteException) {
            Either.Error(Failure.None)
        }
    }

    override suspend fun insertAllPokemon(listPokemonEntity: List<PokemonEntity>): Either<Failure, Unit> {
        return try {
            Either.Success(pokemonDao.insertAll(listPokemonEntity))
        }catch (exception: SQLiteException){
            Either.Error(Failure.None)
        }
    }

    override suspend fun getPokemonWithId(idPokemon: Int): Either<Failure, PokemonEntity?> {
        return try {
            Either.Success(pokemonDao.getPokemonWithId(idPokemon))
        } catch (exception: SQLiteException) {
            Either.Error(Failure.None)
        }
    }


}
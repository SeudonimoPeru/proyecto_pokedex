package com.jhon.data.source.local.room.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.jhon.data.source.local.room.db.base.BaseDao
import com.jhon.data.source.local.room.db.entity.PokemonEntity

@Dao
interface PokemonDao : BaseDao<PokemonEntity> {

    @Query("SELECT * from pokemon_table")
    fun getAllPokemon(): List<PokemonEntity>

    @Query("SELECT * from pokemon_table WHERE name = :idPokemon ")
    fun getPokemonWithId(idPokemon: Int): PokemonEntity?

    @Query("DELETE FROM pokemon_table")
    fun deleteAll()

}
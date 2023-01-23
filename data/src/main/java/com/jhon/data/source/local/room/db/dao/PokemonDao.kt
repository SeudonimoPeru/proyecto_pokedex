package com.jhon.data.source.local.room.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.jhon.data.source.local.room.db.base.BaseDao
import com.jhon.data.source.local.room.db.entity.PokemonEntity

@Dao
interface PokemonDao : BaseDao<PokemonEntity> {

    @Query("SELECT * from pokemon_table")
    fun getAllPokemon(): List<PokemonEntity>

    @Query("DELETE from pokemon_table ")
    fun deleteAll()


    @Query("SELECT * from pokemon_table WHERE name = :idPokemon ")
    fun getPokemonWithId(idPokemon: Int): PokemonEntity?

}
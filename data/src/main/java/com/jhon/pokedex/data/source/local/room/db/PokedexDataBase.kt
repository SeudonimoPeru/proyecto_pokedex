package com.jhon.pokedex.data.source.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jhon.pokedex.data.source.local.room.db.dao.PokemonDao
import com.jhon.pokedex.data.source.local.room.db.entity.PokemonEntity

@Database(
    entities = [
        PokemonEntity::class,
    ],
    version = 1,
    exportSchema = false,
)

abstract class PokedexDataBase : RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao


}
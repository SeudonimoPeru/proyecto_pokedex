package com.jhon.pokedex.data.source.local.room.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    val name: String?,
    @PrimaryKey val id: String,

    )
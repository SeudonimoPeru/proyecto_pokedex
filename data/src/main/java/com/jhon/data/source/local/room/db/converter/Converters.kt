package com.jhon.data.source.local.room.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jhon.data.source.local.room.db.entity.PokemonEntity
import java.lang.reflect.Type

class Converters {

    @TypeConverter
    fun toPokemonTable(pokemonEntity: PokemonEntity): String {
        return Gson().toJson(pokemonEntity)
    }

    @TypeConverter
    fun allPokemonFromTable(datos: String): List<PokemonEntity> {
        val type: Type = object : TypeToken<PokemonEntity?>() {}.type
        return Gson().fromJson(datos, type)
    }
}
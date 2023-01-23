package com.jhon.data.mapper

import com.jhon.data.source.local.room.db.entity.PokemonEntity
import com.jhon.data.source.remote.ds.pokeapi.ListPokemonResponse
import com.jhon.domain.model.PokemonModel

class PokemonMapperImpl : PokemonMapper {
    override suspend fun mapPokemonModelToEntitty(pokemonModel: PokemonModel): PokemonEntity {
        return PokemonEntity(
            pokemonModel.name,
            pokemonModel.id
        )
    }

    override suspend fun mapPokemonEntityToModel(pokemonEntity: PokemonEntity): PokemonModel {
        return PokemonModel(
            pokemonEntity.name!!,
            pokemonEntity.id!!
        )
    }

    override suspend fun mapAllPokemonModelToEntitty(listpokemonModel: List<PokemonModel>): List<PokemonEntity> {
        return listpokemonModel.map {
            PokemonEntity(it.name, it.id)
        }

    }


    override suspend fun mapAllPokemonEntityToModel(listpokemonEntity: List<PokemonEntity>): List<PokemonModel> {
        return listpokemonEntity.map {
            PokemonModel(it.name!!, it.id!!)
        }
    }

    override suspend fun mapListPokemonResponseToModel(pokemonResponse: ListPokemonResponse): List<PokemonModel> {
        return pokemonResponse.pokemonRespons.map {
            PokemonModel(it.name, cleanUrlPokemon(it.url))
        }
    }


    fun cleanUrlPokemon(url: String): Int {
        url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        url.replace("/", "")
        return url.toInt()
    }
}



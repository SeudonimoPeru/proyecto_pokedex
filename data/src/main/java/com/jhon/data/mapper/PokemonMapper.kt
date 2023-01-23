package com.jhon.data.mapper

import com.jhon.data.source.local.room.db.entity.PokemonEntity
import com.jhon.data.source.remote.ds.pokeapi.ListPokemonResponse
import com.jhon.data.source.remote.ds.pokeapi.PokemonResponse

import com.jhon.domain.model.PokemonModel

interface PokemonMapper {

    suspend fun mapPokemonModelToEntitty(pokemonModel: PokemonModel): PokemonEntity
    suspend fun mapPokemonEntityToModel(pokemonEntity: PokemonEntity): PokemonModel

    suspend fun mapAllPokemonModelToEntitty(listpokemonModel:List<PokemonModel>): List<PokemonEntity>
    suspend fun mapAllPokemonEntityToModel(listpokemonEntity: List<PokemonEntity>): List<PokemonModel>



    suspend fun mapListPokemonResponseToModel(pokemonResponse: ListPokemonResponse): List<PokemonModel>



}
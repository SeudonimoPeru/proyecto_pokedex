package com.jhon.pokedex.data.mapper

import com.jhon.domain.model.PokemonDetalleModel
import com.jhon.pokedex.data.source.local.room.db.entity.PokemonEntity
import com.jhon.pokedex.data.source.remote.ds.pokeapi.ListPokemonResponse

import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle.PokemonDetalleResponse

interface PokemonMapper {

    suspend fun mapPokemonModelToEntitty(pokemonModel: PokemonModel): PokemonEntity
    suspend fun mapPokemonEntityToModel(pokemonEntity: PokemonEntity): PokemonModel

    suspend fun mapAllPokemonModelToEntitty(listpokemonModel:List<PokemonModel>): List<PokemonEntity>
    suspend fun mapAllPokemonEntityToModel(listpokemonEntity: List<PokemonEntity>): List<PokemonModel>



    suspend fun mapListPokemonResponseToModel(pokemonResponse: ListPokemonResponse): List<PokemonModel>
    suspend fun mapPokeMonDetalleResponseToModel(pokemonDetalleResponse: PokemonDetalleResponse): PokemonDetalleModel



}
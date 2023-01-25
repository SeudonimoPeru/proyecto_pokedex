package com.jhon.pokedex.mapper

import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.model.PokemonUI

interface PokemonMapperUI {

    suspend fun mapPokemonModelToUI(pokemonModel: PokemonModel): PokemonUI

    suspend fun mapAllPokemonEntityToModel(pokemonModel: List<PokemonModel>): List<PokemonUI>
}
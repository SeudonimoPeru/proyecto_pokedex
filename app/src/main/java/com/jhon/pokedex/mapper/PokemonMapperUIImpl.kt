package com.jhon.pokedex.mapper

import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.model.PokemonUI

class PokemonMapperUIImpl() : PokemonMapperUI {
    override suspend fun mapPokemonModelToUI(pokemonModel: PokemonModel): PokemonUI {
        return PokemonUI(pokemonModel.name, pokemonModel.id)
    }

    override suspend fun mapAllPokemonEntityToModel(pokemonModel: List<PokemonModel>): List<PokemonUI> {
        return pokemonModel.map {
            PokemonUI(it.name, it.id)
        }
    }
}
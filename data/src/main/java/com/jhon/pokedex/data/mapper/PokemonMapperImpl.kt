package com.jhon.pokedex.data.mapper

import com.jhon.pokedex.data.source.local.room.db.entity.PokemonEntity
import com.jhon.pokedex.data.source.remote.ds.pokeapi.ListPokemonResponse
import com.jhon.data.uppercaseFirstLetter
import com.jhon.domain.model.PokemonDetalleModel
import com.jhon.pokedex.data.utils.ConstantsDB
import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle.PokemonDetalleResponse

class PokemonMapperImpl : PokemonMapper {
    override suspend fun mapPokemonModelToEntitty(pokemonModel: PokemonModel): PokemonEntity {
        return PokemonEntity(
            pokemonModel.name,
            pokemonModel.id
        )
    }

    override suspend fun mapPokemonEntityToModel(pokemonEntity: PokemonEntity): PokemonModel {
        return PokemonModel(
            "",
            pokemonEntity.name!!,
            pokemonEntity.id
        )
    }

    override suspend fun mapAllPokemonModelToEntitty(listpokemonModel: List<PokemonModel>): List<PokemonEntity> {
        return listpokemonModel.map {
            PokemonEntity(it.name.lowercase(), it.id)
        }

    }


    override suspend fun mapAllPokemonEntityToModel(listpokemonEntity: List<PokemonEntity>): List<PokemonModel> {
        return listpokemonEntity.map { it ->
            PokemonModel(ConstantsDB.ORIGIN_OF_LOCAL, it.name!!.uppercaseFirstLetter(), it.id)
        }
    }

    override suspend fun mapListPokemonResponseToModel(pokemonResponse: ListPokemonResponse): List<PokemonModel> {
        return pokemonResponse.results.map {
            PokemonModel(ConstantsDB.ORIGIN_OF_REMOTE, it.name.uppercaseFirstLetter(), it.url)
        }
    }

    override suspend fun mapPokeMonDetalleResponseToModel(pokemonDetalleResponse: PokemonDetalleResponse): PokemonDetalleModel {
        with(pokemonDetalleResponse) {
            val pokemondetalle = PokemonDetalleModel(
                this.forms[0].name,
                this.abilities[0].ability.name,
                this.types[0].type.name

            )
            return pokemondetalle
        }


    }

}



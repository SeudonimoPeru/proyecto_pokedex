package com.jhon.data.mapper

import com.jhon.data.source.local.room.db.entity.PokemonEntity
import com.jhon.data.source.remote.ds.pokeapi.ListPokemonResponse
import com.jhon.data.utils.ConstantsDB
import com.jhon.domain.model.PokemonModel
import java.util.*

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
            pokemonEntity.id!!
        )
    }

    override suspend fun mapAllPokemonModelToEntitty(listpokemonModel: List<PokemonModel>): List<PokemonEntity> {
        return listpokemonModel.map {
            PokemonEntity(it.name.lowercase(), it.id)
        }

    }


    override suspend fun mapAllPokemonEntityToModel(listpokemonEntity: List<PokemonEntity>): List<PokemonModel> {
        return listpokemonEntity.map { it ->
            PokemonModel(ConstantsDB.ORIGIN_OF_LOCAL,it.name!!.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }.uppercase(), it.id!!)
        }
    }

    override suspend fun mapListPokemonResponseToModel(pokemonResponse: ListPokemonResponse): List<PokemonModel> {
        return pokemonResponse.results.map {
            PokemonModel(ConstantsDB.ORIGIN_OF_REMOTE,it.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }, it.url)
        }
    }

}



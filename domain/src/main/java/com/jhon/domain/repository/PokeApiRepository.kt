package com.jhon.domain.repository

import com.jhon.domain.model.PokemonModel
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

interface PokeApiRepository {

    suspend fun getAllPokemonWithLimit(offset: Int , limit : Int): Either<Failure, List<PokemonModel>>
}
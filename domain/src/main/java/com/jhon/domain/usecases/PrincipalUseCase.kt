package com.jhon.domain.usecases

import com.jhon.domain.base.BaseUseCase
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.repository.PokeApiRepository
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

class PrincipalUseCase(private val repository: PokeApiRepository) :
    BaseUseCase<List<PokemonModel>, PrincipalUseCase.Params>() {

    data class Params(
        val offset: Int,
        val limit: Int
    )


    override suspend fun run(params: Params): Either<Failure, List<PokemonModel>> {
        return repository.getAllPokemonWithLimit(params.offset, params.limit)
    }


}
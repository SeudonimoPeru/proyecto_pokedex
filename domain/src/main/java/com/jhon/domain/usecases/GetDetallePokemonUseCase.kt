package com.jhon.domain.usecases

import com.jhon.domain.base.BaseUseCase
import com.jhon.domain.model.PokemonDetalleModel
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.repository.PokeApiRepository
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

class GetDetallePokemonUseCase(private val repository: PokeApiRepository) :
    BaseUseCase<PokemonDetalleModel, GetDetallePokemonUseCase.Params>() {

    data class Params(
        val url: String
    )


    override suspend fun run(params: Params): Either<Failure, PokemonDetalleModel> {
        return repository.getDetallePokemon(params.url)
    }


}
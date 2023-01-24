package com.jhon.domain.usecases

import com.jhon.domain.base.BaseUseCase
import com.jhon.domain.model.PokemonModel
import com.jhon.domain.repository.PokeApiRepository
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure

class GuardarPokemonesUseCases(private val repository: PokeApiRepository) :
    BaseUseCase<Unit, GuardarPokemonesUseCases.Params>() {

    data class Params(
        val list: List<PokemonModel>
    )


    override suspend fun run(params: Params): Either<Failure, Unit> {

        if (params.list[0].origin == "remote") {
            val borrarData = repository.deleteTablePokemon()
            if (borrarData is Either.Error) {
                return borrarData
            }
        }

        return repository.insertAllPokemon(params.list)
    }


}
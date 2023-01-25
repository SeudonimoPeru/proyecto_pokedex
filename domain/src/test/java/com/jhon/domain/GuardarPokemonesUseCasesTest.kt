package com.jhon.domain

import com.jhon.domain.model.PokemonModel
import com.jhon.domain.repository.PokeApiRepository
import com.jhon.domain.usecases.GuardarPokemonesUseCases
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GuardarPokemonesUseCasesTest {

    var list: MutableList<PokemonModel> = mutableListOf()

    @RelaxedMockK
    private lateinit var pokeApiRepository: PokeApiRepository
    lateinit var guardarPokemonesUseCases: GuardarPokemonesUseCases

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        guardarPokemonesUseCases = GuardarPokemonesUseCases(pokeApiRepository)
    }

    @Test
    fun `When the list in the index 0 is equals to remote`() = runBlocking {
        val context = this
        list.add(PokemonModel("remote", "", ""))

        guardarPokemonesUseCases(params = GuardarPokemonesUseCases.Params(list), scope = context)

        coVerify(exactly = 1) { pokeApiRepository.deleteTablePokemon() }
        coVerify(exactly = 1) { pokeApiRepository.insertAllPokemon(list) }
    }

    @Test
    fun `When the list in the index 0 is diferent to remote`() = runBlocking {
        val context = this
        list.add(PokemonModel("local", "", ""))

        guardarPokemonesUseCases(params = GuardarPokemonesUseCases.Params(list), scope = context)

        coVerify(exactly = 0) { pokeApiRepository.deleteTablePokemon() }
        coVerify(exactly = 1) { pokeApiRepository.insertAllPokemon(list) }
    }
}
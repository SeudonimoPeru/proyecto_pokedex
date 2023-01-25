package com.jhon.pokedex.data.source.remote.service

import com.jhon.pokedex.data.source.remote.ds.pokeapi.ListPokemonResponse
import com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle.PokemonDetalleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApiService {

    @GET("pokemon/")

    suspend fun getPokemonWithLimit(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ListPokemonResponse>


    @GET
    suspend fun getDetallePokemon(
        @Url url: String
    ): Response<PokemonDetalleResponse>

}
package com.jhon.data.source.remote.service

import com.jhon.data.source.remote.ds.pokeapi.ListPokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon/")

    suspend fun getPokemonWithLimit(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ListPokemonResponse>

}
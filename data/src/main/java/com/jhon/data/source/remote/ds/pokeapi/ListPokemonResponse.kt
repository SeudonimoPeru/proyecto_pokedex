package com.jhon.data.source.remote.ds.pokeapi

data class ListPokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val pokemonRespons: List<PokemonResponse>
)

data class PokemonResponse(
    val name: String,
    val url: String
)
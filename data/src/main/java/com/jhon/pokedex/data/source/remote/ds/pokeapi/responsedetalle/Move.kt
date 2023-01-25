package com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)
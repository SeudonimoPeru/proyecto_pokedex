package com.jhon.pokedex.data.source.remote.ds.pokeapi.responsedetalle

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val red_blue: RedBlue,
    val yellow: Yellow
)
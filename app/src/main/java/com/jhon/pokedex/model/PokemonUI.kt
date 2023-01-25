package com.jhon.pokedex.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonUI(
    val name: String,
    val id: String
) : Parcelable
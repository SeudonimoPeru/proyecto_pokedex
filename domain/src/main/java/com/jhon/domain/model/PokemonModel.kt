package com.jhon.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    var origin: String,
    val name: String,
    val id: String
): Parcelable
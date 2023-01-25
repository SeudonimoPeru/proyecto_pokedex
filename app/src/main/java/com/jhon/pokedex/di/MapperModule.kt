package com.jhon.pokedex.di

import com.jhon.pokedex.mapper.PokemonMapperUI
import com.jhon.pokedex.mapper.PokemonMapperUIImpl
import org.koin.dsl.module


val mapperModule = module {
    factory<PokemonMapperUI> { PokemonMapperUIImpl() }

}
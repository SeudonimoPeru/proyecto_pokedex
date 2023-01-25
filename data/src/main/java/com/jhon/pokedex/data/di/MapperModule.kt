package com.jhon.pokedex.data.di


import com.jhon.pokedex.data.mapper.PokemonMapper
import com.jhon.pokedex.data.mapper.PokemonMapperImpl
import org.koin.dsl.module

val mapperDataModule = module {
    single<PokemonMapper> { PokemonMapperImpl() }



}
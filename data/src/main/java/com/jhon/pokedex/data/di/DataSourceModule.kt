package com.jhon.pokedex.data.di


import com.jhon.pokedex.data.source.local.room.ds.pokemones.AllPokemonDataSource
import com.jhon.pokedex.data.source.local.room.ds.pokemones.AllPokemonDataSourceImpl
import com.jhon.pokedex.data.source.remote.ds.pokeapi.PokeApiDataSource
import com.jhon.pokedex.data.source.remote.ds.pokeapi.PokeApiDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<PokeApiDataSource> { PokeApiDataSourceImpl(get(), get()) }
    single<AllPokemonDataSource> { AllPokemonDataSourceImpl(get()) }


}
package com.jhon.data.di


import com.jhon.data.repository.PokeApiRepositoryImpl
import com.jhon.data.source.local.room.ds.pokemones.AllPokemonDataSource
import com.jhon.data.source.local.room.ds.pokemones.AllPokemonDataSourceImpl
import com.jhon.data.source.remote.ds.pokeapi.PokeApiDataSource
import com.jhon.data.source.remote.ds.pokeapi.PokeApiDataSourceImpl
import com.jhon.domain.repository.PokeApiRepository
import org.koin.dsl.module

val dataSourceModule = module {
    single<PokeApiDataSource> { PokeApiDataSourceImpl(get(), get()) }
    single<AllPokemonDataSource> { AllPokemonDataSourceImpl(get()) }


}
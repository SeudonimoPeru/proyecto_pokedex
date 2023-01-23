package com.jhon.data.di


import com.jhon.data.repository.PokeApiRepositoryImpl
import com.jhon.data.source.remote.ds.pokeapi.PokeApiDataSourceImpl
import com.jhon.domain.repository.PokeApiRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PokeApiRepository>{ PokeApiRepositoryImpl(get(),get(),get(),get()) }


}
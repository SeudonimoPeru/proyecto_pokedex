package com.jhon.pokedex.data.di


import com.jhon.pokedex.data.repository.PokeApiRepositoryImpl
import com.jhon.domain.repository.PokeApiRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PokeApiRepository>{ PokeApiRepositoryImpl(get(),get(),get(),get()) }


}
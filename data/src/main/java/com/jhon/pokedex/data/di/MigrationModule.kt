package com.jhon.pokedex.data.di

import androidx.room.migration.Migration
import org.koin.core.qualifier.named
import org.koin.dsl.module

val migrationsModule =  module{
    single<Set<Migration>>(named("migrations")) {
        HashSet(arrayListOf()) //this is for migrations

    }
}
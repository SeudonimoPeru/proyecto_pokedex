package com.jhon.data.utils

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import com.jhon.data.source.local.room.db.PokedexDataBase
import com.jhon.data.source.local.room.db.dao.PokemonDao

object DataBaseUtils {

    fun provideLocalDataBase(applicationContext: Application, migrations: Set<Migration>): PokedexDataBase {
        return Room.databaseBuilder(applicationContext, PokedexDataBase::class.java, ConstantsDB.DATA_BASE_NAME)
            .addMigrations(*migrations.toTypedArray())
            .build()
    }

    fun providePokemonDao(pokedexDataBase: PokedexDataBase) : PokemonDao {
        return pokedexDataBase.getPokemonDao()
    }


}
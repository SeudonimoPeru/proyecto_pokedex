package com.jhon.pokedex

import android.app.Application
import android.content.Context
import com.jhon.data.di.*
import com.jhon.domain.di.useCasesModule
import com.jhon.pokedex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class PokedexAplication : Application() {
    companion object {
        private lateinit var instance: PokedexAplication
        fun getContextApp(): Context = instance
        fun setInstance(instance: PokedexAplication) {
            this.instance = instance
        }

    }

    override fun onCreate() {
        super.onCreate()
        //System.loadLibrary("native-lib")
        setInstance(this)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PokedexAplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    preferencesModule,
                    migrationsModule,
                    localDataBaseModule,
                    repositoryModule,
                    useCasesModule,
                    dataSourceModule,
                    mapperDataModule


                )
            )

        }
    }
}
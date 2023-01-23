package com.jhon.data.di

import com.jhon.data.utils.ConstantsDB
import com.jhon.data.utils.DataBaseUtils
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val localDataBaseModule = module {
    single {
        DataBaseUtils.provideLocalDataBase(
            androidApplication(),
            get(named(ConstantsDB.GET_MIGRATIONS))
        )
    }

    //Dao
    single { DataBaseUtils.providePokemonDao(get()) }


}
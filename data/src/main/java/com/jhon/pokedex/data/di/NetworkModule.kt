package com.jhon.pokedex.data.di

import com.jhon.pokedex.data.utils.ConnectionUtils
import com.jhon.pokedex.data.utils.ConnectionUtilsImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {


    single<ConnectionUtils> {
        ConnectionUtilsImpl(androidContext())
    }



    single { RetrofitUtils.provideOkHttpClient() }
    single { RetrofitUtils.provideApi(get()) }
    single { RetrofitUtils.provideRetrofit(get()) }
}
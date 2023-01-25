package com.jhon.pokedex.data.di

import com.jhon.pokedex.data.source.local.preferences.PreferencesHelper
import com.jhon.pokedex.data.source.local.preferences.SharedPreferencesKey
import com.jhon.pokedex.data.source.local.preferences.SharedPreferencesUtils.provideSecurePreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val preferencesModule = module {
    single(named("spKey")) { SharedPreferencesKey(androidApplication()) }
    single(named("securePrefs")) { provideSecurePreferences(androidApplication(), get(named("spKey"))) }
    single { PreferencesHelper(get(named("securePrefs"))) }
}



package com.jhon.pokedex.di

import com.jhon.pokedex.main.PrincipalViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { PrincipalViewModel(get(),get(),get(),get()) }


}
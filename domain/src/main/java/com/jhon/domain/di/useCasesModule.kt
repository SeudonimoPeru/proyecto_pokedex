package com.jhon.domain.di

import com.jhon.domain.usecases.PrincipalUseCase
import org.koin.dsl.module

val useCasesModule = module {


    factory { PrincipalUseCase(get()) }

}
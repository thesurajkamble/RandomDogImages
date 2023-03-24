package com.kamblesuraj.dogimagegenerator.domain.di

import com.kamblesuraj.dogimagegenerator.domain.usecase.ClearAllDogsUseCase
import com.kamblesuraj.dogimagegenerator.domain.usecase.GetAllDogsUseCase
import com.kamblesuraj.dogimagegenerator.domain.usecase.GetAllDogsUseCaseImpl
import com.kamblesuraj.dogimagegenerator.domain.usecase.GetRandomDogsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetRandomDogUseCase(
        impl: GetRandomDogsUseCase
    ): GetRandomDogsUseCase

    @Binds
    abstract fun bindGetAllDogsUseCase(
        impl: GetAllDogsUseCaseImpl
    ): GetAllDogsUseCase

    @Binds
    abstract fun bindClearAllDogsUseCase(
        impl: ClearAllDogsUseCase
    ): ClearAllDogsUseCase

}
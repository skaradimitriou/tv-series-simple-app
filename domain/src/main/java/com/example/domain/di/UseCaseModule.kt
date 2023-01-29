package com.example.domain.di

import com.example.domain.repositories.TvShowsRepository
import com.example.domain.usecases.TvShowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: TvShowsRepository): TvShowUseCase {
        return TvShowUseCase(repository)
    }
}
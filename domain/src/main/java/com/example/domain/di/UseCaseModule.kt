package com.example.domain.di

import com.example.domain.repository.TvShowsRepository
import com.example.domain.usecases.TvShowListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCase(repository: TvShowsRepository): TvShowListUseCase {
        return TvShowListUseCase(repository)
    }
}
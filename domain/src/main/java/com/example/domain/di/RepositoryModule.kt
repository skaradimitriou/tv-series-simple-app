package com.example.domain.di

import com.example.data.network.TvShowsService
import com.example.domain.repositories.TvShowsRepository
import com.example.domain.repositories.TvShowsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(api: TvShowsService): TvShowsRepository {
        return TvShowsRepositoryImpl(api)
    }
}
package com.example.data.di

import com.example.data.data.db.TvShowsDao
import com.example.data.data.network.TvShowsService
import com.example.domain.repository.TvShowsRepository
import com.example.data.data.repository.TvShowsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(api: TvShowsService, localDb: TvShowsDao): TvShowsRepository {
        return TvShowsRepositoryImpl(api, localDb)
    }
}
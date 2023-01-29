package com.example.domain.di

import android.app.Application
import com.example.domain.db.TvShowsDao
import com.example.domain.db.TvShowsLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDbModule {

    @Provides
    @Singleton
    fun provideLocalDbReference(app: Application): TvShowsDao {
        return TvShowsLocalDatabase.getDatabase(app).showsDao()
    }
}
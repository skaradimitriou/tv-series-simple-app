package com.example.domain.repository

import com.example.domain.models.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowsRepository {

    suspend fun getTvShows(): Flow<List<TvShow>>

    suspend fun getTvShowById(showId : Int) : Flow<TvShow>
}
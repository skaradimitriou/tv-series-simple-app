package com.example.domain.repositories

import com.example.data.network.TvShowsService
import com.example.domain.db.TvShowsDao
import com.example.domain.mappers.TvSeriesMapper
import com.example.domain.models.TvShow
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val remote: TvShowsService,
    private val localDb: TvShowsDao
) : TvShowsRepository {

    override suspend fun getTvShows(): Flow<List<TvShow>> {
        val data = remote.getTvShows()
        val mappedData = TvSeriesMapper.toDomainModel(data)
        if (localDb.getAllCountries().first().isEmpty()) {
            localDb.insertAll(mappedData)
        } else {
            localDb.updateAll(mappedData)
        }

        return localDb.getAllCountries()
    }
}
package com.example.domain.repositories

import com.example.data.network.TvShowsService
import com.example.domain.db.TvShowsDao
import com.example.domain.mappers.TvSeriesMapper
import com.example.domain.models.TvShow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val remote: TvShowsService,
    private val localDb: TvShowsDao
) : TvShowsRepository {

    override suspend fun getTvShows(): Flow<List<TvShow>> {
        val data = remote.getTvShows()
        val mappedData = TvSeriesMapper.toDomainModel(data)

        return if (mappedData.isEmpty()) {
            localDb.getAllShows()
        } else {
            localDb.updateAll(mappedData)
            localDb.getAllShows()
        }
    }

    override suspend fun getTvShowById(showId: Int): Flow<TvShow> {
        return localDb.getShowById(showId)
    }
}
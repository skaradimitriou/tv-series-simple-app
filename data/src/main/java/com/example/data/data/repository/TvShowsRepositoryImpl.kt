package com.example.data.data.repository

import com.example.data.data.network.TvShowsService
import com.example.data.data.db.TvShowsDao
import com.example.data.data.mappers.TvSeriesMapper
import com.example.domain.models.TvShow
import com.example.domain.repository.TvShowsRepository
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
            localDb.deleteAll()
            localDb.insertAll(mappedData)
            localDb.getAllShows()
        }
    }

    override suspend fun getTvShowById(showId: Int): Flow<TvShow> {
        return localDb.getShowById(showId)
    }
}
package com.example.domain.repositories

import com.example.data.network.TvShowsService
import com.example.domain.mappers.TvSeriesMapper
import com.example.domain.models.TvShow
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val remote: TvShowsService
) : TvShowsRepository {

    override suspend fun getTvShows(): List<TvShow> {
        val data = remote.getTvShows()
        return TvSeriesMapper.toDomainModel(data)
    }
}
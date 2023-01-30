package com.example.data.data.repository

import com.example.data.data.db.TvShowsDao
import com.example.data.data.mappers.TvSeriesMapper
import com.example.data.data.network.TvShowsService
import com.example.domain.models.Result
import com.example.domain.models.TvShow
import com.example.domain.repository.TvShowsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val remote: TvShowsService,
    private val localDb: TvShowsDao
) : TvShowsRepository {

    override suspend fun getTvShows(): Flow<Result<List<TvShow>>> = flow {
        emit(Result.Loading())

        val request = remote.getTvShows()
        if (request.isSuccessful) {
            val data = request.body() ?: listOf()
            val mappedData = TvSeriesMapper.toDomainModel(data)

            if (mappedData.isEmpty()) {
                val localData = localDb.getAllShows().first()
                emit(Result.Success(data = localData))
            } else {
                localDb.deleteAll()
                localDb.insertAll(mappedData)
                val localData = localDb.getAllShows().first()
                emit(Result.Success(data = localData))
            }
        } else {
            //handle error scenario
            emit(Result.Error(error = request.errorBody().toString()))
        }
    }

    override suspend fun getTvShowById(showId: Int): Flow<TvShow> {
        return localDb.getShowById(showId)
    }
}
package com.example.data.data.network

import com.example.data.models.TvShowDto
import retrofit2.Response
import javax.inject.Inject

class TvShowsService @Inject constructor(
    private val api: Endpoints
) {
    suspend fun getTvShows(): Response<List<TvShowDto?>> = api.getTvShows()
}
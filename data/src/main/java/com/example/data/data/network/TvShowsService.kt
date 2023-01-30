package com.example.data.data.network

import com.example.data.models.TvShowDto
import javax.inject.Inject

class TvShowsService @Inject constructor(
    private val api: Endpoints
) {
    suspend fun getTvShows(): List<TvShowDto?> = api.getTvShows().body() ?: listOf()
}
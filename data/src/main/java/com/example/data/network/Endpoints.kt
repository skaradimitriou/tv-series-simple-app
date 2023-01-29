package com.example.data.network

import com.example.data.models.TvShowDto
import retrofit2.Response
import retrofit2.http.GET

interface Endpoints {

    @GET("shows")
    suspend fun getTvShows(): Response<List<TvShowDto?>>
}
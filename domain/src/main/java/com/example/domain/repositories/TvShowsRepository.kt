package com.example.domain.repositories

import com.example.domain.models.TvShow

interface TvShowsRepository {

    suspend fun getTvShows(): List<TvShow>
}
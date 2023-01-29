package com.example.domain.repositories

import com.example.domain.models.TvShow

interface TvShowsRepository {

    fun getTvShows(): List<TvShow>
}
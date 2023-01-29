package com.example.tvseriessimpleapp.presentation.dashboard.shows.adapter

import com.example.domain.models.TvShow

fun interface TvShowCallback {
    fun onTvShowTap(model: TvShow)
}
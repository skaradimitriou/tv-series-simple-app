package com.example.domain.usecases

import com.example.domain.repositories.TvShowsRepositoryImpl

class TvShowUseCase(private val repo: TvShowsRepositoryImpl) {

    fun getTvShows() = repo.getTvShows()
}
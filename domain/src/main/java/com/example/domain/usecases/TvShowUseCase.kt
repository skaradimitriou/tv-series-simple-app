package com.example.domain.usecases

import com.example.domain.repositories.TvShowsRepository
import javax.inject.Inject

class TvShowUseCase @Inject constructor(
    private val repo: TvShowsRepository
) {

    suspend fun getTvShows() = repo.getTvShows()
}
package com.example.domain.usecases

import com.example.domain.repositories.TvShowsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TvShowListUseCase @Inject constructor(
    private val repo: TvShowsRepository
) {

    suspend fun getTvShows() = repo.getTvShows()
}
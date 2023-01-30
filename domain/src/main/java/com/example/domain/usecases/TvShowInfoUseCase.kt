package com.example.domain.usecases

import com.example.domain.repository.TvShowsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TvShowInfoUseCase @Inject constructor(
    private val repo: TvShowsRepository
) {
    suspend fun getTvShowInfo(showId: Int) = repo.getTvShowById(showId)
}
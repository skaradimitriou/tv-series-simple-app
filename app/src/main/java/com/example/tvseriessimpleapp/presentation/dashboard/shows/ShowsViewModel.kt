package com.example.tvseriessimpleapp.presentation.dashboard.shows

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Result
import com.example.domain.models.TvShow
import com.example.domain.usecases.TvShowListUseCase
import com.example.tvseriessimpleapp.abstraction.SimplifiedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(
    app: Application,
    private val useCase: TvShowListUseCase
) : SimplifiedViewModel(app) {

    val shows: LiveData<Result<List<TvShow>>>
        get() = _shows

    private val _shows = MutableLiveData<Result<List<TvShow>>>()

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getTvShows().collect {
                _shows.postValue(it)
            }
        }
    }
}
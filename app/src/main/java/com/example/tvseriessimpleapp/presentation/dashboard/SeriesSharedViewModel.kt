package com.example.tvseriessimpleapp.presentation.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.TvShow
import com.example.domain.usecases.TvShowUseCase
import com.example.tvseriessimpleapp.abstraction.SimplifiedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SeriesSharedViewModel @Inject constructor(
    app: Application,
    private val useCase: TvShowUseCase
) : SimplifiedViewModel(app) {

    val shows: LiveData<List<TvShow>>
        get() = _shows

    private val _shows = MutableLiveData<List<TvShow>>()

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = useCase.getTvShows()
            Timber.d("data => $data")
            _shows.postValue(data)
        }
    }
}
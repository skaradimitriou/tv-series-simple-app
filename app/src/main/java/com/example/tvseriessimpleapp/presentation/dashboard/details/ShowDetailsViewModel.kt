package com.example.tvseriessimpleapp.presentation.dashboard.details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.TvShow
import com.example.domain.models.UiModel
import com.example.domain.usecases.TvShowInfoUseCase
import com.example.tvseriessimpleapp.abstraction.SimplifiedViewModel
import com.example.tvseriessimpleapp.presentation.dashboard.details.model.ShowDescriptionModel
import com.example.tvseriessimpleapp.presentation.dashboard.details.model.ShowDetailHeaderModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailsViewModel @Inject constructor(
    app: Application,
    private val useCase: TvShowInfoUseCase,
    private val dispatcher: CoroutineDispatcher
) : SimplifiedViewModel(app) {

    val screenTitle: LiveData<String>
        get() = _screenTitle

    private val _screenTitle = MutableLiveData<String>()

    val showDetails: LiveData<List<UiModel>>
        get() = _showDetails

    private val _showDetails = MutableLiveData<List<UiModel>>()

    fun getShowInfo(showId: Int) {
        viewModelScope.launch(dispatcher) {
            useCase.getTvShowInfo(showId).collect { show ->
                _screenTitle.postValue(show.title)
                transformToUiModel(show)
            }
        }
    }

    private fun transformToUiModel(model: TvShow) {
        val list = mutableListOf<UiModel>()

        val header = ShowDetailHeaderModel(model.imageUrl, model.title, model.rating)
        val description = ShowDescriptionModel(model.description)

        list.add(header)
        list.add(description)

        _showDetails.postValue(list)
    }
}